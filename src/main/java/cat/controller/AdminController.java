package cat.controller;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cat.common.StrUtil;
import cat.entity.Article;
import cat.entity.Comment;
import cat.entity.User;
import cat.service.ArticleService;
import cat.service.CommentService;
import cat.service.UserService;

/**
 * 用户管理
 */
@Controller 
public class AdminController {
	@Resource
	private UserService userService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private CommentService commentService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginVerify(HttpServletRequest request, HttpServletResponse response, ModelMap m) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("rememberme");

		User user = userService.getUserByNameOrEmail(username);
		if (user == null) {
			m.put("msg", "用户名不正确!");
			return "/login";
		} else if (!user.getUserPass().equals(password)) {
			m.put("msg", "密码不正确!");
			return "/login";
		} else {
			//登录成功
			request.getSession().setAttribute("session_user", user);

			// 如果勾选了记住账号密码
			if (rememberme != null) {
				Cookie nameCookie = new Cookie("username", username);
				nameCookie.setMaxAge(60 * 60 * 24 * 3);
				Cookie pwdCookie = new Cookie("password", password);
				pwdCookie.setMaxAge(60 * 60 * 24 * 3);
				response.addCookie(nameCookie);
				response.addCookie(pwdCookie);
			}

			user.setUserLastLoginTime(new Date());
			user.setUserLastLoginIp(StrUtil.getIpAddr(request));
			userService.updateUser(user);
		}
		
		
        //首面要展示最新的5条文章列表
        List<Article> articleList = articleService.listRecentArticle(5);
        m.put("articleList",articleList);
        
        //首面要展示最新的5条最新评论列表
        List<Comment> commentList = commentService.listRecentComment(5);
        m.put("commentList",commentList);

		return "/index";
	}
}
