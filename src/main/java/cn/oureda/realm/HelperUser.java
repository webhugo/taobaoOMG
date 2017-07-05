package cn.oureda.realm;


import cn.oureda.util.JsonUtil;

import java.io.Serializable;

/**
 * Created by webhugo on 3/13/17.
 */

public class HelperUser implements Serializable{
    private String username;
    private String phone;
    private Long id;

    public HelperUser(String phone, String username, Long id) {
        this.username = username;
        this.phone = phone;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
