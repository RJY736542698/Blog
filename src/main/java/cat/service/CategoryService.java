package cat.service;
import java.util.List;
import cat.entity.Category;

/**
 * 分类
 */
public interface CategoryService {
  
    /**
     * 获得分类列表
     */
    List<Category> listCategory();

    /**
	 * 查询分类列表,对每个分类,要把它下面有多少条文章查出来
	 */
    public List<Category> listCategoryWithArticleCount();

    /**
     * 添加分类
     * @param category 分类信息
     */
	void addCategory(Category category);

	/**
	 * 根据父级分类查询下面所有的子分类
	 * @param parentId 父级分类id,如果 为0,表示查询所有一级分类
	 * @return 子分类列表
	 */
	List<Category> listCategoryByParentId(Integer parentId);
}
