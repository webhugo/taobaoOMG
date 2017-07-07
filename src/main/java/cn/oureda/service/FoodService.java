package cn.oureda.service;

import cn.oureda.dao.BaseDao;
import cn.oureda.util.PageParams;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

import cn.oureda.entity.Food;
import cn.oureda.dao.FoodDao;

@Service
public class FoodService extends BaseService<Food> {

    @Resource
    private FoodDao foodDao;

    @Override
    @Resource(name = "foodDao")
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public int insert(Food pojo) {
        return foodDao.insert(pojo);
    }

    public int insertSelective(Food pojo) {
        return foodDao.insertSelective(pojo);
    }

    public int insertList(List<Food> pojos) {
        return foodDao.insertList(pojos);
    }

    public int update(Food pojo) {
        return foodDao.update(pojo);
    }

    public List<Food> findPrefers(String flag, PageParams params) {
        return foodDao.findPrefers(flag, params);
    }

    public List<Food> search(Set<String> set) {
        return foodDao.search(set);
    }

    public List<Food> findAll(PageParams params) {
        return foodDao.findAllByCreate(params);
    }
}
