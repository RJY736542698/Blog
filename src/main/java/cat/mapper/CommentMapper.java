package cat.mapper;
import cat.entity.Comment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 评论
 */
public interface CommentMapper {
    /**
     * 获得最近评论
     * @param limit 查询出几条
     * @return 列表
     */
    List<Comment> listRecentComment(@Param(value = "limit") Integer limit);

    /**
     * 得到评论列表
     * @return 列表
     */
	List<Comment> listComment();

	/**
	 * 根据id得到评论信息
	 * @param id 评论ID
	 * @return 评论信息
	 */
	Comment getCommentById(Integer id);

	/**
	 * 删除评论
	 * @param id 评论id
	 */
	void deleteComment(Integer id);

	/**
	 * 查询子评论
	 * @param id 评论id
	 * @return 子评论列表
	 */
	List<Comment> listChildComment(Integer id);

}