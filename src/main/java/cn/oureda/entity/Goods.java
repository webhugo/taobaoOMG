package cn.oureda.entity;

/**
 * Created by webhugo on 17-7-6.
 */
public class Goods extends BaseEntity {
    //商品的名字
    private String goods_name;
    //商品的价格
    private Double price;
    //货物数量
    private Integer count;
    //商品的封面
    private String cover;
    //原价
    private Double origin_price;
    //店铺的id
    private Long shop_id;
    //销售次数
    private Integer sell_num;
    //好评次数
    private Integer good_comment;
    //差评次数
    private Integer bad_comment;
    //点击次数
    private Integer click_num;
    //商品类别
    private String type;
    //描述
    private String description;
    //标签,例如今日特惠那些的
    private String flag;

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
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

    public Double getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(Double origin_price) {
        this.origin_price = origin_price;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getSell_num() {
        return sell_num;
    }

    public void setSell_num(Integer sell_num) {
        this.sell_num = sell_num;
    }

    public Integer getGood_comment() {
        return good_comment;
    }

    public void setGood_comment(Integer good_comment) {
        this.good_comment = good_comment;
    }

    public Integer getBad_comment() {
        return bad_comment;
    }

    public void setBad_comment(Integer bad_comment) {
        this.bad_comment = bad_comment;
    }

    public Integer getClick_num() {
        return click_num;
    }

    public void setClick_num(Integer click_num) {
        this.click_num = click_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
