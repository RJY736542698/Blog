package cat.entity;

/**
 * 站点信息
 */
public class Options {
    private Integer optionId;

    //站点名称
    private String optionSiteTitle;

    //站点描述
    private String optionSiteDescrption;

    //首页描述
    private String optionMetaDescrption;

    //首页关键词
    private String optionMetaKeyword;

    //头象图片
    private byte [] optionAboutsitePhoto;

    //昵称
    private String optionAboutsiteTitle;

    //说明
    private String optionAboutsiteContent;

    //微信二维码图片
    private  byte [] optionAboutsiteWechatphoto;

    //QQ
    private String optionAboutsiteQq;

    //git地址
    private String optionAboutsiteGithub;

    //微博
    private String optionAboutsiteWeibo;

    private String optionTongji;

    private Integer optionStatus;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public String getOptionSiteTitle() {
		return optionSiteTitle;
	}

	public void setOptionSiteTitle(String optionSiteTitle) {
		this.optionSiteTitle = optionSiteTitle;
	}

	public String getOptionSiteDescrption() {
		return optionSiteDescrption;
	}

	public void setOptionSiteDescrption(String optionSiteDescrption) {
		this.optionSiteDescrption = optionSiteDescrption;
	}

	public String getOptionMetaDescrption() {
		return optionMetaDescrption;
	}

	public void setOptionMetaDescrption(String optionMetaDescrption) {
		this.optionMetaDescrption = optionMetaDescrption;
	}

	public String getOptionMetaKeyword() {
		return optionMetaKeyword;
	}

	public void setOptionMetaKeyword(String optionMetaKeyword) {
		this.optionMetaKeyword = optionMetaKeyword;
	}


	public String getOptionAboutsiteTitle() {
		return optionAboutsiteTitle;
	}

	public void setOptionAboutsiteTitle(String optionAboutsiteTitle) {
		this.optionAboutsiteTitle = optionAboutsiteTitle;
	}

	public String getOptionAboutsiteContent() {
		return optionAboutsiteContent;
	}

	public void setOptionAboutsiteContent(String optionAboutsiteContent) {
		this.optionAboutsiteContent = optionAboutsiteContent;
	}

	public String getOptionAboutsiteQq() {
		return optionAboutsiteQq;
	}

	public void setOptionAboutsiteQq(String optionAboutsiteQq) {
		this.optionAboutsiteQq = optionAboutsiteQq;
	}

	public String getOptionAboutsiteGithub() {
		return optionAboutsiteGithub;
	}

	public void setOptionAboutsiteGithub(String optionAboutsiteGithub) {
		this.optionAboutsiteGithub = optionAboutsiteGithub;
	}

	public String getOptionAboutsiteWeibo() {
		return optionAboutsiteWeibo;
	}

	public void setOptionAboutsiteWeibo(String optionAboutsiteWeibo) {
		this.optionAboutsiteWeibo = optionAboutsiteWeibo;
	}

	public String getOptionTongji() {
		return optionTongji;
	}

	public void setOptionTongji(String optionTongji) {
		this.optionTongji = optionTongji;
	}

	public Integer getOptionStatus() {
		return optionStatus;
	}

	public void setOptionStatus(Integer optionStatus) {
		this.optionStatus = optionStatus;
	}

	public byte[] getOptionAboutsitePhoto() {
		return optionAboutsitePhoto;
	}

	public void setOptionAboutsitePhoto(byte[] optionAboutsitePhoto) {
		this.optionAboutsitePhoto = optionAboutsitePhoto;
	}

	public byte[] getOptionAboutsiteWechatphoto() {
		return optionAboutsiteWechatphoto;
	}

	public void setOptionAboutsiteWechatphoto(byte[] optionAboutsiteWechatphoto) {
		this.optionAboutsiteWechatphoto = optionAboutsiteWechatphoto;
	}

}