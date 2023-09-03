package cat.mapper;
import java.util.List;
import cat.entity.User;

/**
 * 用户管理接口层
 */
public interface UserMapper {
    /**
     * 根据用户名或Email获得用户信息
     * @param s 用户名或Email
     * @return 用户信息
     */
    User getUserByNameOrEmail(String s) ;

    /**
     * 查询所有用户
     * @return 列表
     */
	List<User> listUser();

	/**
	 * 添加用户
	 * @param user 用户信息,含有照片
	 */
	void addUser(User user);

	/**
	 * 根据id查询用户
	 * @param id 用户id
	 * @return 用户信息,含有照片数据
	 */
	User getUserById(Integer id);

	/**
	 * 删除用户
	 * @param id 用户id
	 */
	void deleteUser(Integer id);
}