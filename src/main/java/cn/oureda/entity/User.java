package cn.oureda.entity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 王佳鑫 on 17-7-5.
 */
public class User extends BaseEntity {
    //登录邮箱
    private String email;
    //登录密码
    private String password;
    //类型,普通用户是1,书店老板是2
    private Integer type;

    //购物车,商品的id,数据库中存的是String,但是实际上是Array数组,需要通过反逆向处理一下
    /**
     * 逆向，String -> 数组
     * String[] goodsIds = rs.replace("[", "").replace("]", "").split(", ");
     */
    private String goods_ids;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getGoods_ids() {
        return goods_ids;
    }

    public void setGoods_ids(String goods_ids) {
        this.goods_ids = goods_ids;
    }

}
