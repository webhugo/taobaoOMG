package cn.oureda.entity;

/**
 * Created by webhugo on 17-7-5.
 */
public class Comment extends BaseEntity {
    //评论的内容
    private String content;
    //对哪件商品做的评论
    private Long goods_id;
    //评论的用户
    private Long user_id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }



}
