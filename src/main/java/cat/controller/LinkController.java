package cat.controller;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cat.entity.Link;
import cat.enums.LinkStatus;
import cat.service.LinkService;

/**
 * 链接维护
 */
@Controller
@RequestMapping("/link")
public class LinkController {

	@Resource
	private LinkService linkService;

	/**
	 * 查出链接列表,转到链接列表页面
	 */
	@RequestMapping("")
	public String linkList(ModelMap m) {
		List<Link> linkList = linkService.listLink(null);
		m.put("linkList", linkList);
		return "/Link/link-list";
	}

	/**
	 * 转到链接添加页面,由于该页面也呈现了链接列表,所以需要查出链列表并传过去
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toLinkAddPage(ModelMap m) {
		List<Link> linkList = linkService.listLink(null);
		m.put("linkList", linkList);
		return "/Link/link-add";
	}

	/**
	 * 添加链接
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertLinkSubmit(Link link) {
		link.setLinkCreateTime(new Date());
		link.setLinkUpdateTime(new Date());
		link.setLinkStatus(LinkStatus.NORMAL.getValue());
		linkService.addLink(link);
		return "forward:/link/add";
	}

	/**
	 * 根据 id 查出链接信息, 转到链接修改页面
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String toLinkEditPage(@PathVariable("id") Integer id, ModelMap m) {
		Link link = linkService.getLinkById(id);
		List<Link> linkList = linkService.listLink(null);
		m.put("link", link);
		m.put("linkList", linkList);
		return "/Link/link-edit";
	}

	/**
	 * 真真的进行链接更新
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editLink(Link link) {
		link.setLinkUpdateTime(new Date());
		linkService.updateLink(link);
		return "forward:/link";
	}

	/**
	 * 删除链接
	 */
	@RequestMapping(value = "/delete/{id}")
	public String deleteLink(@PathVariable("id") Integer id) {
		linkService.deleteLink(id);
		return "forward:/link";
	}
}
