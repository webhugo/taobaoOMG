package cn.oureda.util;

/**
 * Created by webhugo on 3/25/17.
 */
public class PageParams {
    private Integer page;//当前页码
    private Integer pageSize;//每页条数
    private Boolean useFlag;//是否使用插件
    private Boolean checkFlag;//检查当前页码的有效性
    private Integer total;//当前sql返回总条数
    private Integer totalPage;//sql以当前分页的总页数，插件回填
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Boolean getUseFlag() {
        return useFlag;
    }
    public void setUseFlag(Boolean useFlag) {
        this.useFlag = useFlag;
    }
    public Boolean getCheckFlag() {
        return checkFlag;
    }
    public void setCheckFlag(Boolean checkFlag) {
        this.checkFlag = checkFlag;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}