package cat.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cat.entity.Notice;
import cat.mapper.NoticeMapper;
import cat.service.NoticeService;

/**
 * 公告
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    /**
     * 查询公告信息
     */
    @Override
    public List<Notice> listNotice(Integer status)  {
        return noticeMapper.listNotice(status);
    }

    /**
     * 根据id查询公告信息
     */
	@Override
	public Notice getNoticeById(Integer id)  {
	    return noticeMapper.getNoticeById(id);
	}
	
	/**
	 * 更新公告信息
	 */
	@Override
	public void updateNotice(Notice notice)  {
	    noticeMapper.updateNotice(notice);
	}
	
	/**
	 * 添加公告
	 */
	@Override
	public void addNotice(Notice notice)  {
	    noticeMapper.addNotice(notice);
	}
	
	/**
	 * 刪除公告
	 */
	@Override
	public void deleteNotice(Integer id)  {
	    noticeMapper.deleteById(id);
	}

}
