package cn.oureda.entity;

/**
 * Created by 王佳鑫 on 17-7-10.
 */
public class SalesVolume extends BaseEntity {
    private Long goods_id;
    private Double price;

    private Integer count;
    private Double sum;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
