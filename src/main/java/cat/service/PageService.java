package cat.service;
import java.util.List;
import cat.entity.Page;

/**
 * 页面信息
 */
public interface PageService {
    /**
     * 获得页面列表
     *
     * @param status 状态,如果传了可以按它进行查询,如果不传则查询全部
     * @return 列表
     */
    List<Page> listPage(Integer status);

    /**
     * 根据状态和 别名 查询Page
     * @param status 状态
     * @param pageKey 别名
     */
	Page getPageByKey(Integer status, String pageKey);
	

	/**
	 * 添加页面
	 * @param page 页面信息
	 */
    void addPage(Page page);

    /**
     * 删除页面
     * @param id 页面ID
     */
	void deletePage(Integer id);
  
}
