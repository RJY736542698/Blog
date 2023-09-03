package cat.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cat.entity.Article;
import cat.entity.Comment;
import cat.mapper.ArticleMapper;
import cat.mapper.CommentMapper;
import cat.service.CommentService;

/**
 * 评论
 */
@Service
public class CommentServiceImpl implements CommentService {
	
    @Resource
    private CommentMapper commentMapper;
    
    @Resource 
    ArticleMapper articleMapper; 
    
    /**
     * 查询最新评论列表(用于后台首界面)
     */
    public List<Comment> listRecentComment(Integer limit) {
        List<Comment> commentList = commentMapper.listRecentComment(limit);
        
        //把每条评论关联到的文章信息查询出来
		for (int i = 0; i < commentList.size(); i++) {
		    Article article = articleMapper.getArticleById( commentList.get(i).getCommentArticleId());
		    commentList.get(i).setArticle(article);
		}
		
        return commentList;
    }
    
    /**
     * 分页查询评论列表
     */
    @Override
    public PageInfo<Comment> listCommentByPage(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Comment> commentList =commentMapper.listComment();
        for (int i = 0; i < commentList.size(); i++) {
            Article article = articleMapper.getArticleById( commentList.get(i).getCommentArticleId());
            commentList.get(i).setArticle(article);
        }
      
        return new PageInfo<>(commentList);
    }

    /**
     * 根据ID查询回复信息
     */
	@Override
	public Comment getCommentById(Integer id) {
		return commentMapper.getCommentById(id);
	}

	/**
	 * 删除评论
	 */
	public void deleteComment(Integer id) {
		commentMapper.deleteComment(id);
		
	}

	/**
	 * 查询子评论
	 */
	public List<Comment> listChildComment(Integer id) {
		return commentMapper.listChildComment(id);
	}
}
