package cat.service;
import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;

import cat.entity.Article;

/**
 * 文章Service
 */
public interface ArticleService {

    /**
     * 获得最新文章,用于后台首页的言章列表展示
     * @param limit 查询数量
     * @return 列表
     */
    List<Article> listRecentArticle(Integer limit);
    
    
    /**
     * 分页查询文章列表
     *
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示多少
     * @param paramMap  查询条件
     * @return 文章列表
     */
    PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize,  HashMap<String, Object> paramMap);
    
    /**
     * 添加文章
     *
     * @param article 文章,含有分类和标签信息
     */
    void addArticle(Article article);


    /**
     * 根据ID查询文章信息
     * @param id
     * @return 文章信息
     */
	Article getArticleById(Integer id);


	/**
	 * 更新文章的评论数量
	 * @param articleId 文章id
	 */
	void updateCommentCount(Integer articleId);

	
	/**
	 * 删除文章
	 * @param id
	 */
	void deleteArticle(Integer id);

	/**
	 * 更新文章
	 * @param oldArticle 文章信息(含有category 和 tag 的关联信息)
	 */
	void updateArticle(Article oldArticle);

}
