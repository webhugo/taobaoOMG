package cn.oureda.util;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
/**
 * Created by webhugo on 3/25/17.
 */

/**
 * 通过拦截<code>StatementHandler</code>的<code>prepare</code>方法，重写sql语句实现物理分页。
 * 老规矩，签名里要拦截的类型只能是接口。
 *
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})})
public class PagePlugin implements Interceptor {
    private Integer defaultPage;//默认页码
    private Integer defaultPageSize;//默认每页条数
    private Boolean defaultUseFlag;//默认是否启动插件
    private Boolean defaultCheckFlag;//默认是否检测当前页码的正确性
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler stmtHandler = getUnProxyObject(invocation);
        MetaObject metaStatementHandler = SystemMetaObject.forObject(stmtHandler);
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        //不是select语句.
        if (!this.checkSelect(sql)) {
            return invocation.proceed();
        }
        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        Object parameterObject = boundSql.getParameterObject();
        PageParams pageParams = getPageParams(parameterObject);
        if (pageParams == null) { //无法获取分页参数，不进行分页。
            return invocation.proceed();
        }
//获取参数.
        Integer pageNum = pageParams.getPage() == null? this.defaultPage : pageParams.getPage();
        Integer pageSize = pageParams.getPageSize() == null? this.defaultPageSize : pageParams.getPageSize();
        Boolean useFlag = pageParams.getUseFlag() == null? this.defaultUseFlag : pageParams.getUseFlag();
        Boolean checkFlag = pageParams.getCheckFlag() == null? this.defaultCheckFlag : pageParams.getCheckFlag();
        int total = this.getTotal(invocation, metaStatementHandler, boundSql);
        setTotalToParams(pageParams,total,pageSize);
        checkPage(checkFlag, pageNum, pageParams.getTotalPage());
        changeSQL(metaStatementHandler, boundSql, pageNum, pageSize);
        Object data = invocation.proceed();
        return data;
    }
    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }
    @Override
    public void setProperties(Properties props) {
        String strDefaultPage = props.getProperty("default.page","1");
        String strDefaultPageSize = props.getProperty("default.pageSize","50");
        String strDefaultUseFlag = props.getProperty("default.useFlag","false");
        String strDefaultCheckFlag = props.getProperty("default.checkFlag","false");
        this.defaultPage = Integer.parseInt(strDefaultPage);
        this.defaultPageSize = Integer.parseInt(strDefaultPageSize);
        this.defaultUseFlag = Boolean.parseBoolean(strDefaultUseFlag);
        this.defaultCheckFlag = Boolean.parseBoolean(strDefaultCheckFlag);
    }
    private StatementHandler getUnProxyObject(Invocation ivt) {
        StatementHandler statementHandler = (StatementHandler) ivt.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过循环可以分离出最原始的的目标类)
        Object object = null;
        while (metaStatementHandler.hasGetter("h")) {
            object = metaStatementHandler.getValue("h");
        }
        if (object == null) {
            return statementHandler;
        }
        return (StatementHandler) object;
    }
    private boolean checkSelect(String sql) {
        String trimSql = sql.trim();
        int idx = trimSql.toLowerCase().indexOf("select");
        return idx == 0;
    }
    private void checkPage(Boolean checkFlag, Integer pageNum, Integer pageTotal) throws Throwable  {
        if (checkFlag) {
            //检查页码page是否合法.
            if (pageNum > pageTotal) {
                throw new Exception("查询失败，查询页码【" + pageNum + "】大于总页数【" + pageTotal + "】！！");
            }
        }
    }
    private void changeSQL( MetaObject metaStatementHandler, BoundSql boundSql, int page, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException, SQLException, InvocationTargetException {
        //获取当前需要执行的SQL
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        /**
         * TODO 这里使用的是MySQL其他数据库需要修改.
         * 根据你的数据库，修改分页的SQL
         */
        String newSql = "select * from (" + sql + ") $_paging_table limit " + (page - 1) * pageSize + ", " + pageSize;
        //修改当前需要执行的SQL
        metaStatementHandler.setValue("delegate.boundSql.sql", newSql);
    }
    private PageParams getPageParams(Object parameterObject){
        PageParams pageParams = null;
        if (parameterObject == null) {
            return null;
        }
        //处理map参数和@Param注解参数，都是MAP
        if (parameterObject instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> paramMap = (Map<String, Object>) parameterObject;
            Set<String> keySet = paramMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while(iterator.hasNext()) {
                String key = iterator.next();
                Object value = paramMap.get(key);
                if (value instanceof PageParams) {
                    return (PageParams)value;
                }
            }
        } else if (parameterObject instanceof PageParams) { //参数POJO继承了PageParams
            return (PageParams) parameterObject;
        }
        return pageParams;
    }
    private int getTotal(Invocation ivt, MetaObject metaStatementHandler, BoundSql boundSql) throws Throwable {
        //获取当前的mappedStatement
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        //配置对象
        Configuration cfg = mappedStatement.getConfiguration();
        //当前需要执行的SQL
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        /**
         * TODO 如果是其他的数据库需要按你数据库的SQL规范改写.
         * 改写为统计总数的SQL
         */
        String countSql = "select count(*) as total from (" + sql + ") $_paging";
        //获取拦截方法参数，我们知道是Connection对象.
        Connection connection = (Connection) ivt.getArgs()[0];
        PreparedStatement ps = null;
        int total = 0;
        try {
            //预编译统计总数SQL
            ps = connection.prepareStatement(countSql);
            //构建统计总数SQL
            BoundSql countBoundSql = new BoundSql(cfg, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            //构建MyBatis的ParameterHandler用来设置总数Sql的参数。
            ParameterHandler handler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
            //设置总数SQL参数
            handler.setParameters(ps);
            //执行查询.
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
        } finally {
            //这里不能关闭Connection否则后续的SQL就没法继续了。
            if (ps != null && ps.isClosed()) {
                ps.close();
            }
        }
//        System.err.println("总条数：" + total);
        return total;
    }
    private void setTotalToParams(PageParams pageParams,int total,int pageSize){
        pageParams.setTotal(total);
        int totalPage = total % pageSize == 0? total/pageSize:total/pageSize+1;
        pageParams.setTotalPage(totalPage);
    }
}