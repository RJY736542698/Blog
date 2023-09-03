package cat.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import cat.entity.Article;
import cat.entity.Comment;
import cat.service.ArticleService;
import cat.service.CommentService;

/**
 * 评论
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private ArticleService articleService;

    /**
     * 转到评论列表主界面
     * @param pageIndex 页码
     * @param pageSize  页大小
     */
    @RequestMapping(value = "")
    public String commentListView(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                  ModelMap m) {
        PageInfo<Comment> commentPageInfo = commentService.listCommentByPage(pageIndex, pageSize);
        m.put("pageInfo", commentPageInfo);
        
        m.put("pageUrlPrefix","comment?pageIndex");
        return "/Comment/comment-list";
    }

    /**
     * 删除评论,要连子评论一起删除,还要更新对应的文章的评论数
     */
     @RequestMapping(value = "/delete/{id}")
	public void deleteComment(@PathVariable("id") Integer id) {
	    Comment comment = commentService.getCommentById(id);
	    //删除评论
	    commentService.deleteComment(id);
	    //删除其子评论
	    List<Comment> childCommentList = commentService.listChildComment(id);
	    for (int i = 0; i < childCommentList.size(); i++) {
	        commentService.deleteComment(childCommentList.get(i).getCommentId());
	    }
	    
	    //更新文章的评论数
	    Article article = articleService.getArticleById( comment.getCommentArticleId());
	    articleService.updateCommentCount(article.getArticleId());
	}
}
