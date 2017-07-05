package cn.oureda.entity;

/**
 * Created by webhugo on 17-7-5.
 */
public class User extends BaseEntity {
    //登录电话
    private String phone;
    //登录密码
    private String password;
    //类型,普通用户是1,书店老板是2
    private Integer type;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
