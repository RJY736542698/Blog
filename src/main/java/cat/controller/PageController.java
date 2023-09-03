package cat.controller;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cat.entity.Page;
import cat.enums.PageStatus;
import cat.service.PageService;

@Controller
@RequestMapping("/page")
public class PageController {
    @Resource
    private PageService pageService;

    /**
     * 后台页面列表
     */
    @RequestMapping(value = "")
    public String index(ModelMap m) {
        List<Page> pageList = pageService.listPage(null);
        m.put("pageList",pageList);
        return "Page/page-list";
    }
    
    /**
     * 转到添加page的页面 
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String toAddPage() { 
        return "/Page/page-add";
    }
    
    /**
     * 添加页面
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPage(Page page,ModelMap m) {
        //判断别名是否存在
        Page oldPage = pageService.getPageByKey(null, page.getPageKey());
        if (oldPage == null) {
            page.setPageCreateTime(new Date());
            page.setPageUpdateTime(new Date());
            page.setPageStatus(PageStatus.NORMAL.getValue());
            pageService.addPage(page);
        }
        else {
        	m.put("msg", "别名已经存在,添加失败!");
        }
        return "forward:/page";
    }
    
    
    /**
     * 删除页面
     */
    @RequestMapping(value = "/delete/{id}")
    public String deletePage(@PathVariable("id") Integer id) {
        pageService.deletePage(id);
        return "forward:/page";
    }

}



