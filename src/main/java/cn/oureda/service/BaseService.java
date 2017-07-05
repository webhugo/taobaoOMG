package cn.oureda.service;


import cn.oureda.dao.BaseDao;
import cn.oureda.entity.BaseEntity;

import java.io.Serializable;

/**
 * Created by webhugo on 17-5-10.
 */

public class BaseService<T extends BaseEntity> {

    protected BaseDao<T> baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public int delete(Serializable id) {
        return baseDao.delete(id);
    }

    public T find(Serializable id) {
        T t = baseDao.find(id);
        return t;
    }
}
