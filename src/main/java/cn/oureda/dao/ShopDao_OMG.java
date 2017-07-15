package cn.oureda.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

import cn.oureda.entity.Shop;
import org.springframework.stereotype.Repository;

/**
 * Created by 曹婉悦 on 17-7-5.
 */
@Repository
public interface ShopDao_OMG extends BaseDao_OMG<Shop> {
    int insert(@Param("pojo") Shop pojo);

    int insertSelective(@Param("pojo") Shop pojo);

    int insertList(@Param("pojos") List<Shop> pojo);

    int update(@Param("pojo") Shop pojo);

    Shop findByBossId(@Param("userId") Serializable findByBossId);
}

