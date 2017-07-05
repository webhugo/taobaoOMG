package cn.oureda.entity;

import cn.oureda.util.JsonUtil;

/**
 * Created by webhugo on 17-7-5.
 */
public class BaseEntity {
    //作为数据库的主键
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
