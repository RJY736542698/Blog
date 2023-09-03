package cat.mapper;
import java.util.HashMap;
import java.util.List;
import cat.entity.Article;

/**
 * 文章 
 */
public interface ArticleMapper {
	/**
	 * 获得最新文章
	 * @param limit 查询数量
	 * @return 列表
	 */
	List<Article> listRecentArticle(Integer limit);

	/**
	 * 根据文章id得到文章信息
	 * @param id 文章id
	 * @return 文章信息
	 */
	Article getArticleById(Integer id);
	
    /**
     * 获得所有的文章
     * @param paramMap 查询条件
     * @return 文章列表
     */
    List<Article> findAll(HashMap<String, Object> paramMap);

    /**
     * 添加文章
     * @param article 文章信息
     */
	void addArticle(Article article);

	/**
	 * 更新文章的评论数量
	 * @param articleId 文章ID
	 */
	void updateCommentCount(Integer articleId);

    /**
     * 用户的文章数
     * @param id 用户 ID
     * @return 数量
     */
    Integer countArticleByUser(Integer id);

    /**
     * 删除文章
     * @param id 文章id
     */
	void deleteArticle(Integer id);

	/**
	 * 更新文章信息
	 */
	void updateArticle(Article article);


}