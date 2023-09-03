package cat.service;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import cat.entity.Comment;
import java.util.List;

/**
 * 评论
 */
@Service
public interface CommentService {
	/**
	 * 最新评论,用于index.jsp最新评论列表展示
	 * @param limit 要查出几条
	 * @return 评论列表
	 */
    List<Comment> listRecentComment(Integer limit);
    
    /**
     * 获取所有评论列表
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示数量
     * @return 列表
     */
    PageInfo<Comment> listCommentByPage( Integer pageIndex, Integer pageSize);


    /**
     * 根据id获取评论
     * @param id
     * @return 评论信息
     */
     Comment getCommentById(Integer id);

     /**
      * 删除评论
      * @param id 评论ID
      */
      void deleteComment(Integer id);

      /**
       * 获得评论的子评论
       * @param id 评论ID
       * @return 子评论列表
       */
       List<Comment> listChildComment(Integer id);
      
    
    /**
     * 添加评论
     *
     * @param comment 评论
     */
  //  void insertComment(Comment comment);

    /**
     * 根据文章id获取评论列表
     *
     * @param articleId 文章ID
     * @return 列表
     */
   // List<Comment> listCommentByArticleId(Integer articleId);

  



    /**
     * 获得评论列表
     *
     * @return 列表
     */
 //   List<Comment> listComment();



    /**
     * 修改评论
     *
     * @param comment 评论
     */
 //   void updateComment(Comment comment);

    /**
     * 统计评论数
     *
     * @return 数量
     */
 //   Integer countComment();



  

    
}
