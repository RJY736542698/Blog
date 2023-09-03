package cat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cat.entity.Tag;
import cat.mapper.ArticleTagRefMapper;
import cat.mapper.TagMapper;
import cat.service.TagService;

/**
 * Tag标签
 */
@Service
public class TagServiceImpl implements TagService {
	@Resource
	private TagMapper tagMapper;

	@Resource 
    private ArticleTagRefMapper articleTagRefMapper;
	
	/**
	 * 得到标签列表
	 */
	@Override
	public List<Tag> listTag() {
		return tagMapper.listTag();
	}

	/**
	 * 得到标签列表,并计算出每个标签对应的文章数
	 */
	@Override
	public List<Tag> listTagWithArticleCount() {
		List<Tag> tagList = tagMapper.listTag();
		for (int i = 0; i < tagList.size(); i++) {
			Integer count = articleTagRefMapper.countArticleByTagId(tagList.get(i).getTagId());
			tagList.get(i).setArticleCount(count);
		}
		return tagList;
	}

	/**
	 * 添加标签
	 */
	@Override
	public void addTag(Tag tag) {
		 tagMapper.addTag(tag);
	}

}
