package cn.oureda.service;


import cn.oureda.dao.BaseDao_OMG;
import cn.oureda.entity.BaseEntity;

import java.io.Serializable;


/**
 * service层,和dao层进行交互
 * Created by 程山川 on 17-7-5.
 * @param <T>
 */
public class BaseService_OMG<T extends BaseEntity> {

    protected BaseDao_OMG<T> baseDaoOMG;

    public void setBaseDaoOMG(BaseDao_OMG baseDaoOMG) {
        this.baseDaoOMG = baseDaoOMG;
    }

    public int delete(Serializable id) {
        return baseDaoOMG.delete(id);
    }

    public T find(Serializable id) {
        T t = baseDaoOMG.find(id);
        return t;
    }

    protected void Time(T t){
        t.setCreate_time(System.currentTimeMillis());
        t.setUpdate_time(System.currentTimeMillis());
    }
}
