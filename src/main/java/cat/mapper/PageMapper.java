package cat.mapper;
import cat.entity.Page;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 页面
 */
public interface PageMapper {
    /**
     * 获得页面列表
     * 
     * @param status 状态
     * @return 页面列表
     */
    List<Page> listPage(Integer status);

    /**
     * 根据状态 和别名查询Page,
     * @param status 状态 (1 为显示,0为隐藏)
     * @param pageKey 别名
     * @return Page信息
     */
	Page getPageByKey(@Param(value = "status") Integer status,  @Param(value = "key") String pageKey);
    
	/**
	 * 添加页面
	 * @param page 页面信息
	 */
	void addPage(Page page);

	/**
	 * 删除页在, 
	 * @param id 页面ID
	 */
	void deletePage(Integer id);
}