package cn.oureda.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.oureda.entity.Food;
import cn.oureda.dao.FoodDao;

@Service
public class FoodService{

    @Resource
    private FoodDao foodDao;

    public int insert(Food pojo){
        return foodDao.insert(pojo);
    }

    public int insertSelective(Food pojo){
        return foodDao.insertSelective(pojo);
    }

    public int insertList(List<Food> pojos){
        return foodDao.insertList(pojos);
    }

    public int update(Food pojo){
        return foodDao.update(pojo);
    }
}
