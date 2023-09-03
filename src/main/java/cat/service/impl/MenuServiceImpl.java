package cat.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cat.entity.Menu;
import cat.mapper.MenuMapper;
import cat.service.MenuService;

/**
 * 菜单
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 查所有菜单
     */
    @Override
    public List<Menu> listMenu() {
        List<Menu> menuList = menuMapper.listMenu();
        return menuList;
    }

    /**
     * 添加菜单
     */
	 @Override
	public void addMenu(Menu menu) {
	    menuMapper.addMenu(menu);
	}
	
	/**
	 * 删除菜单
	 * @param id
	 */
	@Override
	public void deleteMenu(Integer id) {
	    menuMapper.deleteMenu(id);
	}
	
	/**
	 * 根据id查询菜单
	 * @param id 菜单ID
	 * @return 菜单
	 */
	@Override
	public Menu getMenuById(Integer id) {
	    return menuMapper.getMenuById(id);
	}
	
	/**
	 * 更新菜单
	 */
	@Override
	public void updateMenu(Menu menu) {
	    menuMapper.updateMenu(menu);
	}
	

}
