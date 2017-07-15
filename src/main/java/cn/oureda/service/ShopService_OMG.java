package cn.oureda.service;

import cn.oureda.dao.BaseDao_OMG;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import cn.oureda.entity.Shop;
import cn.oureda.dao.ShopDao_OMG;
/**
 * Created by 程山川 on 17-7-5.
 */
@Service
public class ShopService_OMG extends BaseService_OMG<Shop> {

    @Resource
    private ShopDao_OMG shopDao;

    @Override
    @Resource(name = "shopDao_OMG")
    public void setBaseDaoOMG(BaseDao_OMG baseDaoOMG) {
        super.setBaseDaoOMG(baseDaoOMG);
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

    public Shop findByBossId(Serializable bossId){
        return shopDao.findByBossId(bossId);
    }
}
