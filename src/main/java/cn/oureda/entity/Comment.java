package cn.oureda.entity;

/**
 * Created by webhugo on 17-7-5.
 */
public class Comment extends BaseEntity {
    //评论的内容
    private String content;
    //对哪件商品做的评论
    private Long GoodsId;
    //评论的用户
    private Long userId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(Long goodsId) {
        GoodsId = goodsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
