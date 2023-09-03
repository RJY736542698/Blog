package cat.service;
import java.util.List;

import cat.entity.Link;

/**
 * 链接
 */
public interface LinkService {

    /**
     * 获得链接列表
     * 
     * @param status 状态(1 显示 0 隐藏),如果传null查询所有
     * @return 链接列表
     */
    List<Link> listLink(Integer status);

    /**
     * 创建链接
     * @param link 链接信息
     */
	void addLink(Link link);

	/**
	 * 根据id查询Link
	 * @param id link的id
	 * @return link信息
	 */
	Link getLinkById(Integer id);

	/**
	 * 更新链接信息
	 * @param link 链接信息
	 */
	void updateLink(Link link);

	/**
	 * 根据id删除链接
	 * @param id 链接id
	 */
	void deleteLink(Integer id);
}
