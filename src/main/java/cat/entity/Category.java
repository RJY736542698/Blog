package cat.entity;
/**
 * 分类
 */
public class Category {
	private Integer categoryId;

	//所属父级id
    private Integer categoryPid;

    //分类名称
    private String categoryName;

    //分类描述
    private String categoryDescription;

    //分类排序
    private Integer categoryOrder;

    //分类图标
    private String categoryIcon;

    //文章数量(非数据库字段)
    private Integer articleCount;

    public Category() {}
   
	/* public Category(Integer categoryId, Integer categoryPid, String categoryName, String categoryDescription, Integer categoryOrder, String categoryIcon,Integer articleCount) {
	    this.categoryId = categoryId;
	    this.categoryPid = categoryPid;
	    this.categoryName = categoryName;
	    this.categoryDescription = categoryDescription;
	    this.categoryOrder = categoryOrder;
	    this.categoryIcon = categoryIcon;
	    this.articleCount = articleCount;
	}*/

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 未分类
     *
     * @return 分类
     */
    public static Category getDefault() {
        return new Category(100000000, "未分类");
    }

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryPid() {
		return categoryPid;
	}

	public void setCategoryPid(Integer categoryPid) {
		this.categoryPid = categoryPid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Integer getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(Integer categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	public String getCategoryIcon() {
		return categoryIcon;
	}

	public void setCategoryIcon(String categoryIcon) {
		this.categoryIcon = categoryIcon;
	}

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
}