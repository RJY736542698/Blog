package cat.service;

import java.util.List;
import cat.entity.Menu;

/**
 * 菜单
 */
public interface MenuService {
	/**
	 * 获得菜单列表
	 * @return 列表
	 */
	List<Menu> listMenu();

	/**
	 * 添加菜单
	 * @param menu 菜单
	 */
	void addMenu(Menu menu);

	/**
	 * 删除菜单项目
	 * @param id 菜单ID
	 */
	void deleteMenu(Integer id);

	/**
	 * 根据id获得菜单项目信息
	 * @param id 菜单ID
	 * @return 菜单
	 */
	Menu getMenuById(Integer id);

	/**
	 * 更新菜单项目
	 * @param menu 菜单
	 */
	void updateMenu(Menu menu);

}
