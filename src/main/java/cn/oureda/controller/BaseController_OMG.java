package cn.oureda.controller;

import cn.oureda.cache.RedisUtil_OMG;
import cn.oureda.entity.User;
import cn.oureda.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 作为控制层的基类
 *
 * @param <T>
 */
public class BaseController_OMG<T> {


    //log4j的错误日志记录
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //作为返回前端的cookie的键
    private final static String cookieName = "taobaoName";

    /*
    采取springmvc的依赖注入
     */
    @Autowired
    private RedisUtil_OMG redisUtil;
    @Resource
    protected FoodService_OMG foodService;
    @Resource
    protected UserService_OMG userService;
    @Resource
    protected ShopService_OMG shopService;
    @Resource
    protected CommentService_OMG commentService;
    @Resource
    protected SalesVolumeService_OMG salesVolumeService;


    /**
     * 辅助工具函数,利用java反射机制用于获取request对象的值
     *
     * @param request
     * @param key
     * @param defaultValue
     * @param type
     * @param <T>
     * @return
     */
    protected static <T> T getRequestValue(HttpServletRequest request, String key, T defaultValue, Class<T> type) {
        String obj = request.getParameter(key);
        if (obj == null)
            return defaultValue;
        if (type.getSimpleName().equals("String")) {
            return (T) obj;
        }
        Method method = null;
        try {
            method = type.getMethod("valueOf", String.class);
            return (T) method.invoke(null, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 通过redis作为session,保存服务器端的用户状态,和前端的cookie值进行校验
     *
     * @param response
     * @param user
     */
    protected void helperLogin(HttpServletResponse response, User user) {
        redisUtil.set(user.getId().toString(), user);
        Cookie cookie = new Cookie(cookieName, user.getId().toString());
        response.addCookie(cookie);
    }

    /**
     * 通过前端的request对象,把保存在redis中的user对象获取出来
     *
     * @param request
     * @return
     */
    protected User User(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            String value = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName))
                    value = cookie.getValue();
            }
            if (value == null)
                return null;
            User user = (User) redisUtil.get(value);
            System.out.print("user:");
            System.out.println(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 把user对象添加到model对象中,返回给前端
     *
     * @param model
     * @param request
     */
    protected void UserAdd(ModelAndView model, HttpServletRequest request) {
        User user = User(request);
        model.addObject("user", user);
    }
}