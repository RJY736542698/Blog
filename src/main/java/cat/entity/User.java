package cat.entity;
import java.util.Date;

/**
 * 管理员信息实体类
 */
public class User{
    private Integer userId;
    private String userName;
    private String userPass;
    private String userNickname;
    private String userEmail;
    private String userUrl; 
    private String userAvatar; 
    private String userLastLoginIp;   
    private Date userRegisterTime;   
    private Date userLastLoginTime; 
    private Integer userStatus; 
    private byte [] userPhoto;  //用户照片

    //文章数量（非数据库字段）
    private Integer articleCount;  

    
    
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserLastLoginIp() {
		return userLastLoginIp;
	}

	public void setUserLastLoginIp(String userLastLoginIp) {
		this.userLastLoginIp = userLastLoginIp;
	}

	public Date getUserRegisterTime() {
		return userRegisterTime;
	}

	public void setUserRegisterTime(Date userRegisterTime) {
		this.userRegisterTime = userRegisterTime;
	}

	public Date getUserLastLoginTime() {
		return userLastLoginTime;
	}

	public void setUserLastLoginTime(Date userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	public byte[] getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
	}
}