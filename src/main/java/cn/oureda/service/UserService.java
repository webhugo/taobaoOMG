package cn.oureda.service;

import cn.oureda.dao.BaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import cn.oureda.entity.User;
import cn.oureda.dao.UserDao;

@Service
public class UserService extends BaseService<User> {

    @Resource
    private UserDao userDao;

    @Override
    @Resource(name = "userDao")
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public int insert(User pojo) {
        return userDao.insert(pojo);
    }

    public int insertSelective(User pojo) {
        return userDao.insertSelective(pojo);
    }

    public int insertList(List<User> pojos) {
        return userDao.insertList(pojos);
    }

    public int update(User pojo) {
        return userDao.update(pojo);
    }

    public User selectByEmailAndPassword(String email, String password) {
        return userDao.selectByEmailAndPassword(email, password);
    }

    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }
}
