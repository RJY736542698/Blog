package cat.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cat.entity.Menu;
import cat.service.MenuService;

/**
 * 菜单
 */
@Controller @RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 转到后台列表页
     */
    @RequestMapping(value = "")
    public String index(Model model)  {
        List<Menu> menuList = menuService.listMenu();
        model.addAttribute("menuList",menuList);
        return "/Menu/menu-list";
    }

    /**
     * 添加菜单
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
	public String addMenu(Menu menu)  {
    	
	    //如果用户不指定顺序,顺序是1
	    if(menu.getMenuOrder()==null) {
	    	menu.setMenuOrder(1);
	    }
	    
	    menuService.addMenu(menu);
	    
	    return "forward:/menu";
	}

    /**
     * 删除菜单
     */
    @RequestMapping(value = "/delete/{id}")
	public String deleteMenu(@PathVariable("id") Integer id)  {
	    menuService.deleteMenu(id);
	    return "forward:/menu";
	}

    /**
     * 转到菜单修改页
     */
    @RequestMapping(value = "/edit/{id}",method=RequestMethod.GET)
	public String toMenuEditPage(@PathVariable("id") Integer id,ModelMap m)  {
	    Menu menu =  menuService.getMenuById(id);
	    List<Menu> menuList = menuService.listMenu();
	    
	    m.put("menuList", menuList);
	    m.put("menu", menu);
	    
	    return "/Menu/menu-edit";
	}

    /**
     * 真正的进行菜单更新
     */
	 @RequestMapping(value = "/edit",method = RequestMethod.POST)
	 public String editMenu(Menu menu)  {
	    menuService.updateMenu(menu);
	    return "forward:/menu";
	 }
}
