package cn.oureda.dao;

import cn.oureda.util.PageParams_OMG;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

import cn.oureda.entity.Food;
import org.springframework.stereotype.Repository;

/**
 * Created by 曹婉悦 on 17-7-5.
 */
@Repository
public interface FoodDao_OMG extends BaseDao_OMG<Food> {
    int insert(@Param("pojo") Food pojo);

    int insertSelective(@Param("pojo") Food pojo);

    int insertList(@Param("pojos") List<Food> pojo);

    int update(@Param("pojo") Food pojo);

    List<Food> findAll(@Param("shopId") Long shopId);

    List<Food> findPrefers(@Param("flag") String flag, PageParams_OMG params);

    List<Food> search(@Param("strSet") Set<String> stringSet);

    List<Food> findAllByCreate(PageParams_OMG params);

    List<Food> findPrefersAndShopId(@Param("flag") String flag,@Param("shopId") Integer shopId,PageParams_OMG params);

    List<Food> findByShopId(@Param("shopId") Integer shopId);
}

