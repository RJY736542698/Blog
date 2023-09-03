package cat.service;
import java.util.List;

import cat.entity.User;

/**
 * 用户管理服务类接口
 */
public interface UserService {
    /**
     * 根据用户名和邮箱查询用户
     * @param s 用户名或Email
     * @return 用户的信息(含有密码信息)
     */
    User getUserByNameOrEmail(String s);

    /**
     * 更新用户信息,比如用户登录以后要更新它的最后登录时间等
     * @param user
     */
	void updateUser(User user);

	/**
	 * 查询用户列表
	 * @return 列表
	 */
	List<User> listUser();

	/**
	 * 添加用户(同时添加照片信息)
	 * @param user 用户
	 */
	void addUser(User user);

	/**
	 * 根据id查询用户信息
	 * @param id 用户id
	 * @return 用户信息(含有照片)
	 */
	User getUserById(Integer id);

	/**
	 * 删除用户
	 * @param id 用户ID
	 */
	void deleteUser(Integer id); 
}
