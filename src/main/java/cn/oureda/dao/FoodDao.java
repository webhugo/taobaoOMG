package cn.oureda.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.oureda.entity.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDao {
    int insert(@Param("pojo") Food pojo);

    int insertSelective(@Param("pojo") Food pojo);

    int insertList(@Param("pojos") List<Food> pojo);

    int update(@Param("pojo") Food pojo);
}
