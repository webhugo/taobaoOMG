package cn.oureda.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.oureda.entity.Shop;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao extends BaseDao<Shop>{
    int insert(@Param("pojo") Shop pojo);

    int insertSelective(@Param("pojo") Shop pojo);

    int insertList(@Param("pojos") List<Shop> pojo);

    int update(@Param("pojo") Shop pojo);
}

