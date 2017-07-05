package cn.oureda.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * Created by webhugo on 17-5-10.
 */
public interface BaseDao<T> {

    T find(@Param("id") Serializable id);

    int delete(@Param("id") Serializable id);


}
