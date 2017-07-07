package cn.oureda.service;

import cn.oureda.dao.BaseDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cn.oureda.entity.Comment;
import cn.oureda.dao.CommentDao;

@Service
public class CommentService extends BaseService<Comment>{

    @Resource
    private CommentDao commentDao;

    @Override
    @Resource(name = "commentDao")
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
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
}
