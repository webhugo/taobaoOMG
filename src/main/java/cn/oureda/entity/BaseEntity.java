package cn.oureda.entity;

import cn.oureda.util.JsonUtil;

import java.io.Serializable;

/**
 * Created by webhugo on 17-7-5.
 */
public class BaseEntity implements Serializable{
    //作为数据库的主键
    protected Long id;
    protected Long create_time;
    protected Long update_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
