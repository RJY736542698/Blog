package cat.mapper;
import java.util.List;
import cat.entity.Link;

/**
 * 链接
 */
public interface LinkMapper {
	/**
	 * 查询链接列表
	 * @param status 链接状态(1 显示  0隐藏),传null表示查询全部
	 * @return 列表
	 */
    List<Link> listLink(Integer status);

    /**
     * 添加链接
     * @param link 链接信息
     */
	void addLink(Link link);

	/**
	 * 根据id查询link信息
	 * @param id lin的id
	 * @return link信息
	 */
	Link getLinkById(Integer id);

	
	/**
	 * 真正的更新链接信息
	 * @param link 链接信息
	 */
	void updateLink(Link link);

	/**
	 * 根据id删除链接
	 * @param id
	 */
	void deleteLink(Integer id);
}