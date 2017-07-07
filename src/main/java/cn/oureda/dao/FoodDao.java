package cn.oureda.dao;

import cn.oureda.util.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

import cn.oureda.entity.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDao extends BaseDao<Food> {
    int insert(@Param("pojo") Food pojo);

    int insertSelective(@Param("pojo") Food pojo);

    int insertList(@Param("pojos") List<Food> pojo);

    int update(@Param("pojo") Food pojo);

    List<Food> findAll(@Param("shopId") Long shopId);

    List<Food> findPrefers(@Param("flag") String flag, PageParams params);

    List<Food> search(@Param("strSet") Set<String> stringSet);

    List<Food> findAllByCreate(PageParams params);
}

