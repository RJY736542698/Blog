package cat.mapper;
import java.util.List;
import cat.entity.Menu;

/**
 * 菜单
 */
public interface MenuMapper {
	/**
	 * 获得菜单列表
	 * @return 列表
	 */
	List<Menu> listMenu();

	/**
	 * 添加
	 * @param menu 菜单
	 */
	void addMenu(Menu menu);

	/**
	 * 删除
	 * @param menuId 菜单ID
	 */
	void deleteMenu(Integer menuId);

	/**
	 * 根据ID查询
	 * @param menuId 菜单ID
	 * @return 菜单
	 */
	Menu getMenuById(Integer menuId);

	/**
	 * 更新
	 * @param menu 菜单
	 */
	void updateMenu(Menu menu);

}