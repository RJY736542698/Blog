package cat.mapper;

import java.util.List;

import cat.entity.ArticleCategoryRef;
import cat.entity.Category;

/**
 * 文章分类关联表
 * 这个类没有定义业务层
 */
public interface ArticleCategoryRefMapper {
	/**
	 * 根据文章ID获得分类列表
	 *
	 * @param articleId 文章ID
	 * @return 分类列表
	 */
	List<Category> listCategoryByArticleId(Integer articleId);
	
    /**
     * 添加文章和分类关联记录
     * @param record 一条关联记录
     */
    void addArticleCategory(ArticleCategoryRef record);

    /**
     * 查询每个分类下面有多少条文章
     * @param categoryId 分类id
     * @return 文章数量
     */
	Integer countArticleByCategoryId(Integer categoryId);

	/**
	 * 删除言章和分类的关联(通常是在更新了或删除了文章之后)
	 * @param articleId 文章ID
	 */
	void deleteByArticleId(Integer articleId);
}