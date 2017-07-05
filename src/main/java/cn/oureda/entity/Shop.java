package cn.oureda.entity;

/**
 * Created by webhugo on 17-7-5.
 */
public class Shop extends BaseEntity {
    //商店名字
    private String shopName;
    //书店的介绍
    private String description;


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
