package cat.mapper;
import cat.entity.Notice;
import java.util.List;

/**
 * 公告
 */
public interface NoticeMapper {
    /**
     * 获得公告列表
     * 
     * @param status 状态(1 显示 0隐藏) 传null将查询所有
     * @return 公告列表
     */
    List<Notice> listNotice(Integer status);
    
    /**
     * 根据ID查询
     * 
     * @param noticeId 公告ID
     * @return 公告
     */
    Notice getNoticeById(Integer noticeId);
    
    /**
     * 更新公告
     * 
     * @param notice 公告
     * @return 影响行数
     */
    void updateNotice(Notice notice);
       
    /**
     * 添加公告
     * 
     * @param notice 公告
     */
    void addNotice(Notice notice);
    
    /**
     * 根据ID删除
     * 
     * @param noticeId 公告ID
     */
    void deleteById(Integer noticeId);

}