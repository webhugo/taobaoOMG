package cn.oureda.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

import cn.oureda.entity.SalesVolume;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesVolumeDao_OMG extends BaseDao_OMG<SalesVolume> {
    int insert(@Param("pojo") SalesVolume pojo);

    int insertSelective(@Param("pojo") SalesVolume pojo);

    int insertList(@Param("pojos") List<SalesVolume> pojo);

    int update(@Param("pojo") SalesVolume pojo);

    SalesVolume findByGoods_id(@Param("goods_id") Serializable goods_id);
}
