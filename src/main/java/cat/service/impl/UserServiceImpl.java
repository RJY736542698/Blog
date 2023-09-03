package cat.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cat.entity.User;
import cat.mapper.ArticleMapper;
import cat.mapper.UserMapper;
import cat.service.UserService;

/**
 * 用户管理
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    
    @Resource
    private ArticleMapper articleMapper;

    /**
     * 根据用户名或邮箱查询用户
     */
	@Override
	public User getUserByNameOrEmail(String s) {
		return userMapper.getUserByNameOrEmail(s);
	}

	@Override
	public void updateUser(User user) {
		
	}
	
	/**
	 * 查询用户列表(同时查询出每个人发布了几个文章
	 */
    @Override
    public List<User> listUser() {
        List<User> userList = userMapper.listUser();
        for (int i = 0; i < userList.size(); i++) {
            Integer articleCount = articleMapper.countArticleByUser(userList.get(i).getUserId());
            userList.get(i).setArticleCount(articleCount);
        }
        return userList;
    }

    /**
     *添加用户,同时添加照片信息
     */
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	/**
	 * 根据id查询用户信息(带有照片信息)
	 */
	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	/**
	 * 根据id删除用户
	 */
	@Override
	public void deleteUser(Integer id) {
		 userMapper.deleteUser(id);
	}
}
