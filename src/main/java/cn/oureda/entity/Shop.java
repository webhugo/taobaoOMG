package cn.oureda.entity;

/**
 * Created by 王佳鑫 on 17-7-5.
 */
public class Shop extends BaseEntity {
    //商店名字
    private String shop_name;
    //商店的介绍
    private String description;
    //商店的封面
    private String cover;
    //老板的id
    private Long boss_id;

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Long getBoss_id() {
        return boss_id;
    }

    public void setBoss_id(Long boss_id) {
        this.boss_id = boss_id;
    }
}
