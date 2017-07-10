package cn.oureda.service;

import cn.oureda.dao.BaseDao_OMG;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import cn.oureda.entity.SalesVolume;
import cn.oureda.dao.SalesVolumeDao_OMG;

@Service
public class SalesVolumeService_OMG extends BaseService_OMG<SalesVolume>{

    @Resource
    private SalesVolumeDao_OMG salesVolumeDao;

    @Override
    @Resource(name = "salesVolumeDao_OMG")
    public void setBaseDaoOMG(BaseDao_OMG baseDaoOMG) {
        super.setBaseDaoOMG(baseDaoOMG);
    }

    public int insert(SalesVolume pojo){
        return salesVolumeDao.insert(pojo);
    }

    public int insertSelective(SalesVolume pojo){
        return salesVolumeDao.insertSelective(pojo);
    }

    public int insertList(List<SalesVolume> pojos){
        return salesVolumeDao.insertList(pojos);
    }

    public int update(SalesVolume pojo){
        return salesVolumeDao.update(pojo);
    }

    public SalesVolume findByGoods_id(Serializable goods_id){
        return salesVolumeDao.findByGoods_id(goods_id);
    }
}
