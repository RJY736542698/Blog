package cat.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cat.entity.Article;
import cat.entity.ArticleCategoryRef;
import cat.entity.ArticleTagRef;
import cat.entity.Category;
import cat.entity.Tag;
import cat.enums.ArticleCommentStatus;
import cat.mapper.ArticleCategoryRefMapper;
import cat.mapper.ArticleMapper;
import cat.mapper.ArticleTagRefMapper;
import cat.service.ArticleService;

/**
 * 文章Servie实现
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleMapper articleMapper;

	@Resource
	private ArticleCategoryRefMapper articleCategoryRefMapper;
	
	@Resource
	private ArticleTagRefMapper articleTagRefMapper;

	/**
	 * 查询最近文章列表
	 */
	public List<Article> listRecentArticle(Integer limit) {
		return articleMapper.listRecentArticle(limit);
	}

	/**
	 * 分页查询文章列表(同时把某个文章所属哪些分类也查出来了) 要注意,实现分页查询,需要在mybatis的主配置文件中配置分页插件
	 */
	public PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize, HashMap<String, Object> paramMap) {
		PageHelper.startPage(pageIndex, pageSize);
		List<Article> articleList = articleMapper.findAll(paramMap);

		for (int i = 0; i < articleList.size(); i++) {
			// 封装CategoryList
			List<Category> categoryList = articleCategoryRefMapper.listCategoryByArticleId(articleList.get(i).getArticleId());
			if (categoryList == null || categoryList.size() == 0) {
				categoryList = new ArrayList<>();
				categoryList.add(Category.getDefault());
			}
			articleList.get(i).setCategoryList(categoryList);
		}

		return new PageInfo<Article>(articleList);
	}

	/**
	 * 添加文章, 同时添加文章和分类的关联,文章和标签的关联
	 */
	@Override
	public void addArticle(Article article) {
		// 添加文章
		article.setArticleCreateTime(new Date());
		article.setArticleUpdateTime(new Date());
		article.setArticleIsComment(ArticleCommentStatus.ALLOW.getValue());
		article.setArticleViewCount(0);
		article.setArticleLikeCount(0);
		article.setArticleCommentCount(0);
		article.setArticleOrder(1);
		articleMapper.addArticle(article);
		
		// 添加分类和文章关联
		for (int i = 0; i < article.getCategoryList().size(); i++) {
			ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef(article.getArticleId(), article.getCategoryList().get(i).getCategoryId());
			articleCategoryRefMapper.addArticleCategory(articleCategoryRef);
		}
		// 添加标签和文章关联
		for (int i = 0; i < article.getTagList().size(); i++) {
			ArticleTagRef articleTagRef = new ArticleTagRef(article.getArticleId(), article.getTagList().get(i).getTagId());
			articleTagRefMapper.addArticleTag(articleTagRef);
		}
	}

	/**
	 * 根据ID查询文章信息
	 */
	@Override
	public Article getArticleById(Integer id) {
	   Article article = articleMapper.getArticleById(id);
        if (article != null) {
            List<Category> categoryList = articleCategoryRefMapper.listCategoryByArticleId(article.getArticleId());
            List<Tag> tagList = articleTagRefMapper.listTagByArticleId(article.getArticleId());
            article.setCategoryList(categoryList);
            article.setTagList(tagList);
        }
        return article;
	}
	
	/**
	 * 更新评论数量
	 */
	@Override
    public void updateCommentCount(Integer articleId) {
        articleMapper.updateCommentCount(articleId);
    }

    /**
     * 删除文章,本方法没有删除文章关联的评论等信息以及文章关联的图片信息
     */
	@Override
	public void deleteArticle(Integer id) {
		articleMapper.deleteArticle(id);
	}

	/**
	 * 更新文章信息
	 */
	@Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);

        if (article.getTagList() != null) {
            //删除标签和文章关联
            articleTagRefMapper.deleteByArticleId(article.getArticleId());
            
            //添加标签和文章关联
            for (int i = 0; i < article.getTagList().size(); i++) {
                ArticleTagRef articleTagRef = new ArticleTagRef(article.getArticleId(), article.getTagList().get(i).getTagId());
                articleTagRefMapper.addArticleTag(articleTagRef);
            }
        }

        if (article.getCategoryList() != null) {
            //添加分类和文章关联
            articleCategoryRefMapper.deleteByArticleId(article.getArticleId());
            
            //删除分类和文章关联
            for (int i = 0; i < article.getCategoryList().size(); i++) {
                ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef(article.getArticleId(), article.getCategoryList().get(i).getCategoryId());
                articleCategoryRefMapper.addArticleCategory(articleCategoryRef);
            }
        }
    }
}
