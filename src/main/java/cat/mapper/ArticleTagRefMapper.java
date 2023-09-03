package cat.mapper;

import java.util.List;

import cat.entity.ArticleTagRef;
import cat.entity.Tag;

/**
 * 文章和标签的关联关系
 */
public interface ArticleTagRefMapper {
    /**
     * 添加文章和标签关联记录
     * @param record 关联对象
     */
    void addArticleTag(ArticleTagRef record);

    /**
     * 得到某个标签对应的文章数量
     * @param tagId 标签id
     * @return 文章数量
     */
	Integer countArticleByTagId(Integer tagId);

	/**
	 * 删除文章和标签的关联(通常是在删除或更新了文章之后)
	 * @param articleId 文章标签
	 */
	void deleteByArticleId(Integer articleId);

	/**
	 * 查出文章关联到的全部tag
	 * @param articleId 文章ID
	 * @return tag 列表
	 */
	List<Tag> listTagByArticleId(Integer articleId);
}