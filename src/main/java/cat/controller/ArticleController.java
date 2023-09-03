package cat.controller;

import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import cat.entity.*;
import cat.service.*;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HtmlUtil;

/**
 * 文章 关于文章的请求,都是有 /article前缀
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource
	private ArticleService articleService;

	@Resource
	private CategoryService categoryService;

	@Resource
	private TagService tagService;

	/**
	 * 文章列表
	 * 
	 * @param pageIndex 当前第几页
	 * @param pageSize  每页大小
	 * @param status    状态
	 * @param model     用于作用域数据传递
	 */
	@RequestMapping(value = "")
	public String index(@RequestParam(required = false, defaultValue = "1") Integer pageIndex, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String status, ModelMap m) {

		HashMap<String, Object> paramMap = new HashMap<>(1);
		if (status == null) {
			m.put("pageUrlPrefix", "article?pageIndex");
		} else {
			paramMap.put("status", status);
			m.put("pageUrlPrefix", "article?status=" + status + "&pageIndex");
		}

		PageInfo<Article> articlePageInfo = articleService.getPageArticleList(pageIndex, pageSize, paramMap);
		m.put("pageInfo", articlePageInfo);

		return "/Article/article-list";
	}

	/**
	 * 转到文章页添加页面,因为该页面中要选 Tag 和 分类,所以把它们的信息带过去
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toArticleAddPage(ModelMap m) {
		List<Category> categoryList = categoryService.listCategory();
		List<Tag> tagList = tagService.listTag();
		m.put("categoryList", categoryList);
		m.put("tagList", tagList);

		return "/Article/article-add";
	}

	/**
	 * 真正的进行文章添加
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addArticle(HttpServletRequest request) {
		Article article = new Article();
		// 用户ID
		User user = (User) request.getSession().getAttribute("session_user");
		if (user != null) {
			article.setArticleUserId(user.getUserId());
		}

		article.setArticleTitle(request.getParameter("articleTitle"));
		article.setArticleContent(request.getParameter("articleContent"));
		article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));

		// 文章摘要
		String str = HtmlUtil.cleanHtmlTag(request.getParameter("articleContent"));
		article.setArticleSummary(str.length() > 150 ? str.substring(0, 150) : str);

		// 一级分类ID
		String articleParentCategoryId = request.getParameter("articleParentCategoryId");

		// 二级分类ID
		String articleChildCategoryId = request.getParameter("articleChildCategoryId");

		// 填充article中的分类列表
		List<Category> categoryList = new ArrayList<>(2);
		if (StrUtil.isNotEmpty(articleParentCategoryId)) {
			categoryList.add(new Category(Integer.parseInt(articleParentCategoryId)));
		}
		if (StrUtil.isNotEmpty(articleChildCategoryId)) {
			categoryList.add(new Category(Integer.parseInt(articleChildCategoryId)));
		}
		article.setCategoryList(categoryList);

		// 填充article中的标签列表
		List<Tag> tagIdList = new ArrayList<>();
		String[] tagIds = request.getParameterValues("articleTagIds");
		if (tagIds != null) {
			for (int i = 0; i < tagIds.length; i++) {
				tagIdList.add(new Tag(Integer.parseInt(tagIds[i])));
			}
		}
		article.setTagList(tagIdList);

		articleService.addArticle(article);
		return "forward:/article";
	}

	/**
	 * 删除文章
	 */
	@RequestMapping(value = "/delete/{id}")
	public String deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return "forward:/article";
	}

	/**
	 * 转到编辑文章页面
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String toArticleEditPage(@PathVariable("id") Integer id, ModelMap m) {
		Article article = articleService.getArticleById(id);
		m.put("article", article);

		List<Category> categoryList = categoryService.listCategory();
		m.put("categoryList", categoryList);

		List<Tag> tagList = tagService.listTag();
		m.put("tagList", tagList);

		return "Article/article-edit";
	}

	/**
	 * 真正的编辑文章,对于分类和tag表中的关联信息,应该先全删除,再进行添加
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editArticleSubmit(HttpServletRequest request) {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		Article oldArticle = articleService.getArticleById(articleId);

		oldArticle.setArticleTitle(request.getParameter("articleTitle"));
		oldArticle.setArticleContent(request.getParameter("articleContent"));
		oldArticle.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));

		// 文章摘要
		String str = HtmlUtil.cleanHtmlTag(request.getParameter("articleContent"));
		oldArticle.setArticleSummary(str.length() > 150 ? str.substring(0, 150) : str);

		// 一级分类ID
		String articleParentCategoryId = request.getParameter("articleParentCategoryId");

		// 二级分类ID
		String articleChildCategoryId = request.getParameter("articleChildCategoryId");

		// 填充article中的分类列表
		List<Category> categoryList = new ArrayList<>(2);
		if (StrUtil.isNotEmpty(articleParentCategoryId)) {
			categoryList.add(new Category(Integer.parseInt(articleParentCategoryId)));
		}
		if (StrUtil.isNotEmpty(articleChildCategoryId)) {
			categoryList.add(new Category(Integer.parseInt(articleChildCategoryId)));
		}
		oldArticle.setCategoryList(categoryList);

		// 填充article中的标签列表
		List<Tag> tagIdList = new ArrayList<>();
		String[] tagIds = request.getParameterValues("articleTagIds");
		if (tagIds != null) {
			for (int i = 0; i < tagIds.length; i++) {
				tagIdList.add(new Tag(Integer.parseInt(tagIds[i])));
			}
		}
		oldArticle.setTagList(tagIdList);

		articleService.updateArticle(oldArticle);
		return "forward:/article";
	}

}
