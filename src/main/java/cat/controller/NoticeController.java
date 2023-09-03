package cat.controller;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cat.entity.Notice;
import cat.enums.NoticeStatus;
import cat.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;

	/**
	 * 公告列表
	 */
	@RequestMapping(value = "")
	public String index(ModelMap m) {
		List<Notice> noticeList = noticeService.listNotice(null);
		m.put("noticeList", noticeList);
		return "/Notice/notice-list";
	}

	/**
	 * 查出公告信息后转到编辑页面
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editNoticeView(@PathVariable("id") Integer id, ModelMap m) {
		Notice notice = noticeService.getNoticeById(id);
		m.put("notice", notice);
		return "/Notice/notice-edit";
	}

	/**
	 * 真正的进行公告更新
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editNoticeSubmit(Notice notice) {
		notice.setNoticeUpdateTime(new Date());
		noticeService.updateNotice(notice);
		return "forward:/notice";
	}
	
	/**
	 * 转到添加公告页面
	 */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
	public String insertNoticeView() {
	    return "/Notice/notice-add";
	}
    

	/**
	 * 真正的添加公告
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNotice(Notice notice) {
	    notice.setNoticeCreateTime(new Date());
	    notice.setNoticeUpdateTime(new Date());
	    notice.setNoticeStatus(NoticeStatus.NORMAL.getValue());
	    notice.setNoticeOrder(1);
	    noticeService.addNotice(notice);
	    return "forward:/notice";
	}
	
	/**
	 * 删除公告
	 */
	@RequestMapping(value = "/delete/{id}")
	public String deleteNotice(@PathVariable("id") Integer id) {
	    noticeService.deleteNotice(id);
	    return "forward:/notice";
	}	
}
