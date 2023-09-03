package cat.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cat.entity.Page;
import cat.mapper.PageMapper;
import cat.service.PageService;

/**
 * 页面信息
 */
@Service
public class PageServiceImpl implements PageService {

    @Resource
    private PageMapper pageMapper;

    /**
     * 查询页面信息列表,如果status传null,则查询全部
     */
    @Override
    public List<Page> listPage(Integer status) {
        return pageMapper.listPage(status);
    }

    /**
     * 根据状态(1 为显示,0为隐藏) 和别名查询Page,
     */
    @Override
    public Page getPageByKey(Integer status, String pageKey) {
        return pageMapper.getPageByKey(status, pageKey);
    }

	/**
	 * 添加页面
	 */
	public void addPage(Page page) {
		pageMapper.addPage(page);
	}

	/**
	 * 删除页面
	 */
	public void deletePage(Integer id) {
		 pageMapper.deletePage(id);
	}

}
