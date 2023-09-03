package cat.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cat.entity.Category;
import cat.mapper.ArticleCategoryRefMapper;
import cat.mapper.CategoryMapper;
import cat.service.CategoryService;

/**
 * 分类
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryMapper categoryMapper;

	@Resource
	private ArticleCategoryRefMapper articleCategoryRefMapper;

	/**
	 * 查询分类列表
	 */
	@Override
	public List<Category> listCategory() {
		return categoryMapper.listCategory();
	}

	/**
	 * 查询分类列表,对每个分类,要把它下面有多少条文章查出来
	 */
	@Override
	public List<Category> listCategoryWithArticleCount() {
		List<Category> categoryList = categoryMapper.listCategory();

		for (Category c : categoryList) {
			c.setArticleCount(articleCategoryRefMapper.countArticleByCategoryId(c.getCategoryId()));
		}

		return categoryList;
	}

	/**
	 * 添加分类
	 */
	@Override
	public void addCategory(Category category) {
		categoryMapper.addCategory(category);
	}

	/**
	 * 根据父级分类查询所有子分类
	 */
	@Override
	public List<Category> listCategoryByParentId(Integer parentId) {
		return categoryMapper.listCategoryByParentId(parentId); 
	}
}
