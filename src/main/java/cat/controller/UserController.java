package cat.controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import cat.entity.User;
import cat.service.UserService;

/**
 * @author liuyanzhao
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户列表
     */
    @RequestMapping(value = "")
    public ModelAndView userList()  {
        ModelAndView modelandview = new ModelAndView();
        List<User> userList = userService.listUser();
        modelandview.addObject("userList",userList);
        modelandview.setViewName("/User/user-list");
        return modelandview;
    }

    /**
     * 转到添加用户页面
     */
	@RequestMapping(value = "/add",method =RequestMethod.GET )
	public String toUserAddPage()  {
	    return "/User/user-add";
	}

	 /**
     * 真正的添加用户(同时添加用户照片,注意,photo这个名字不要和实体类中的字段userPhoto同名,否则会出错
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST  )
	public String add(User user, MultipartFile photo) throws IOException  {
	    //此处要加上用户名和邮箱如果有人已经使用则不能再用的校验,略
	     user.setUserRegisterTime(new Date());
	     user.setUserStatus(1);
	     user.setUserPhoto(photo.getBytes());
	     userService.addUser(user);
	    
	    return "forward:/user";
	}
	
	/**
	 * 提取出用户对应的图片数据,传到前台展示
	 */
	@RequestMapping("/photo/{id}")
	public void showPhoto(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
  		User user=userService.getUserById(id);
  		response.setContentType("image/jpg");		
  		ServletOutputStream outstream =response.getOutputStream();	
  		outstream.write(user.getUserPhoto());
  		outstream.flush();
	}	
  
    /**
     * 删除用户
     */
    @RequestMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id)  {
	    userService.deleteUser(id);
	    return "forward:/user";
	}
}
