package cn.oureda.service;

import cn.oureda.dao.BaseDao_OMG;
import cn.oureda.util.PageParams_OMG;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

import cn.oureda.entity.Food;
import cn.oureda.dao.FoodDao_OMG;

@Service
public class FoodService_OMG extends BaseService_OMG<Food> {

    @Resource
    private FoodDao_OMG foodDao;

    @Override
    @Resource(name = "foodDao_OMG")
    public void setBaseDaoOMG(BaseDao_OMG baseDaoOMG) {
        super.setBaseDaoOMG(baseDaoOMG);
    }

    public int insert(Food pojo) {
        pojo.setSell_num(0);
        pojo.setClick_num(0);
        Time(pojo);
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

    public List<Food> findPrefers(String flag, PageParams_OMG params) {
        return foodDao.findPrefers(flag, params);
    }

    public List<Food> search(Set<String> set) {
        return foodDao.search(set);
    }

    public List<Food> findAll(PageParams_OMG params) {
        return foodDao.findAllByCreate(params);
    }

    public List<Food> findPrefersAndShopId(String flag, Integer shopId, PageParams_OMG params) {
        return foodDao.findPrefersAndShopId(flag, shopId, params);
    }

    public List<Food> findByShopId(Integer shopId) {
        return foodDao.findByShopId(shopId);
    }
}
