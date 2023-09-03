package cat.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cat.entity.Tag;
import cat.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    /**
     * 标签列表
     */
    @RequestMapping(value = "")
    public String index(ModelMap m)  {
        List<Tag> tagList = tagService.listTagWithArticleCount();
        m.put("tagList",tagList); 
        return "Tag/tag-list";
    }

    /**
     * 添加标签
     */
    @RequestMapping("/add")
    public String insertTagSubmit(Tag tag)  {
        tagService.addTag(tag);
        return "redirect:/tag";
    }
}
