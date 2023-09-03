package cat.service;

import java.util.List;
import cat.entity.Tag;

/**
 * Tag 标签
 */
public interface TagService {

	/**
	 * 获得标签列表
	 *
	 * @return 标签列表
	 */
	List<Tag> listTag();

	/**
	 * 得到标签列表,并计算出每个标签关联的文章数
	 * 
	 * @return 标签列表
	 */
	List<Tag> listTagWithArticleCount();

	/**
	 * 添加标签
	 * 
	 * @param tag
	 */
	void addTag(Tag tag);
}
