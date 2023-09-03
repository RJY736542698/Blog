package cat.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cat.entity.Category;
import cat.service.CategoryService;

/**
 * 分类
 */
@Controller @RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 转到分页列表,每个分类要计算出它含有的文章个数
     */
    @RequestMapping(value = "")
    public String index(ModelMap m)  {
        List<Category> categoryList = categoryService.listCategoryWithArticleCount();
        m.put("categoryList",categoryList);
        return "/Category/category-list";
    }

    /**
     * 添加分类
     */
    @RequestMapping("/add")
    public String addCategory(Category c)  {
        categoryService.addCategory(c);
        return "redirect:/category";
    }
    
    /**
     * 根据父分类id查询下面的所有子分类
     */
    @ResponseBody
    @RequestMapping("/listsub")
    public List<Category> listSubCategory(Integer parentCateId){
    	List<Category> categoryList= categoryService.listCategoryByParentId(parentCateId);
    	return categoryList;
    }
}
