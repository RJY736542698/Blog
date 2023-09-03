package cat.mapper;
import cat.entity.Category;
import java.util.List;

/**
 * 分类
 */
public interface CategoryMapper {

    /**
     * 获得分类列表
     *
     * @return 列表
     */
    List<Category> listCategory();

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