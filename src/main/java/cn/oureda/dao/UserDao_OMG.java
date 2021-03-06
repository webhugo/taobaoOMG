package cn.oureda.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.oureda.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 曹婉悦 on 17-7-5.
 */
@Repository
public interface UserDao_OMG extends BaseDao_OMG<User> {
    int insert(@Param("pojo") User pojo);

    int insertSelective(@Param("pojo") User pojo);

    int insertList(@Param("pojos") List<User> pojo);

    int update(@Param("pojo") User pojo);

    User selectByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    User findByEmail(@Param("email") String email);
}
