package cn.oureda.service;

import cn.oureda.dao.BaseDao_OMG;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.oureda.entity.Comment;
import cn.oureda.dao.CommentDao_OMG;

/**
 * Created by 程山川 on 17-7-5.
 */
@Service
public class CommentService_OMG extends BaseService_OMG<Comment> {

    @Resource
    private CommentDao_OMG commentDao;

    @Override
    @Resource(name = "commentDao_OMG")
    public void setBaseDaoOMG(BaseDao_OMG baseDaoOMG) {
        super.setBaseDaoOMG(baseDaoOMG);
    }

    public int insert(Comment pojo){
        return commentDao.insert(pojo);
    }

    public int insertSelective(Comment pojo){
        return commentDao.insertSelective(pojo);
    }

    public int insertList(List<Comment> pojos){
        return commentDao.insertList(pojos);
    }

    public int update(Comment pojo){
        return commentDao.update(pojo);
    }

    public List<Comment> findByGoodsId(Integer shopId){
        return commentDao.findByGoodsId(shopId);
    }
}
