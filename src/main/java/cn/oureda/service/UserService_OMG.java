package cn.oureda.service;

import cn.oureda.dao.BaseDao_OMG;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import cn.oureda.entity.User;
import cn.oureda.dao.UserDao_OMG;

@Service
public class UserService_OMG extends BaseService_OMG<User> {

    @Resource
    private UserDao_OMG userDao;

    @Override
    @Resource(name = "userDao_OMG")
    public void setBaseDaoOMG(BaseDao_OMG baseDaoOMG) {
        super.setBaseDaoOMG(baseDaoOMG);
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
