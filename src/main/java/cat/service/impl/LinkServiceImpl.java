package cat.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cat.entity.Link;
import cat.mapper.LinkMapper;
import cat.service.LinkService;

/**
 * 链接状态
 */
@Service
public class LinkServiceImpl implements LinkService {
	
	@Resource
	private LinkMapper linkMapper;
	
	/**
	 * 根据状态(1 显示 0 隐藏)查询链接列表,如果传null则查询所有
	 */
	@Override
	public List<Link> listLink(Integer status)  {
		return linkMapper.listLink(status);
	}

	/**
	 * 添加链接
	 */
	@Override
	public void addLink(Link link) {
		linkMapper.addLink(link);
		
	}

	/**
	 * 根据id查询link信息
	 */
	@Override
	public Link getLinkById(Integer id) {
		return linkMapper.getLinkById(id);
	}

	/**
	 * 真正的更新链接信息
	 */
	@Override
	public void updateLink(Link link) {
		linkMapper.updateLink(link);
	}

	/**
	 * 根据id删除链接
	 */
	@Override
	public void deleteLink(Integer id) {
		linkMapper.deleteLink(id);
	}
}
