package cn.oureda.service;

import cn.oureda.dao.BaseDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.oureda.entity.Shop;
import cn.oureda.dao.ShopDao;

@Service
public class ShopService extends BaseService<Shop>{

    @Resource
    private ShopDao shopDao;

    @Override
    @Resource(name = "shopDao")
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public int insert(Shop pojo){
        return shopDao.insert(pojo);
    }

    public int insertSelective(Shop pojo){
        return shopDao.insertSelective(pojo);
    }

    public int insertList(List<Shop> pojos){
        return shopDao.insertList(pojos);
    }

    public int update(Shop pojo){
        return shopDao.update(pojo);
    }
}
