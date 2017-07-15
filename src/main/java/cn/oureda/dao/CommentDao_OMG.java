package cn.oureda.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.oureda.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * Created by 曹婉悦 on 17-7-5.
 */
@Repository
public interface CommentDao_OMG extends BaseDao_OMG<Comment> {
    int insert(@Param("pojo") Comment pojo);

    int insertSelective(@Param("pojo") Comment pojo);

    int insertList(@Param("pojos") List<Comment> pojo);

    int update(@Param("pojo") Comment pojo);

    List<Comment> findByGoodsId(@Param("goods_id") Integer goods_id);
}

