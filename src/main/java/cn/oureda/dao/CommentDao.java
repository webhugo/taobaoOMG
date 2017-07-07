package cn.oureda.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.oureda.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends BaseDao<Comment>{
    int insert(@Param("pojo") Comment pojo);

    int insertSelective(@Param("pojo") Comment pojo);

    int insertList(@Param("pojos") List<Comment> pojo);

    int update(@Param("pojo") Comment pojo);
}

