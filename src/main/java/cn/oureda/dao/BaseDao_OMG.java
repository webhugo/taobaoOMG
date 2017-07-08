package cn.oureda.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * dao层,和底层数据库进行交互
 * @param <T>
 */
public interface BaseDao_OMG<T> {

    T find(@Param("id") Serializable id);

    int delete(@Param("id") Serializable id);


}
