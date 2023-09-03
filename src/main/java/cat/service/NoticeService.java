package cat.service;
import java.util.List;
import cat.entity.Notice;

/**
 * 公告
 */
public interface NoticeService {
    /**
     * 获得公告列表
     * 
     * @param status 状态(1 显示,0 隐藏) ,传null将获取全部
     */
    List<Notice> listNotice(Integer status);

    /**
     * 根据id查询公告
     * 
     * @param id ID
     * @return 公告
     */
    Notice getNoticeById(Integer id);
    
    /**
     * 更新公告
     * 
     * @param notice 公告
     */
     void updateNotice(Notice notice);


    /**
     * 添加公告
     * 
     * @param notice 公告
     */
     void addNotice(Notice notice);

    /**
     * 删除公告
     * 
     * @param id
     */
     void deleteNotice(Integer id);
}
