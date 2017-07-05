package cn.oureda.entity;

/**
 * Created by webhugo on 17-7-5.
 */
public class Food extends BaseEntity {
    //商品的名字
    private String goodsName;
    //商品的价格
    private Double price;
    //货物数量
    private Integer count;
    //商品的封面
    private String cover;
    //原价
    private Double originPrice;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Double originPrice) {
        this.originPrice = originPrice;
    }
}
