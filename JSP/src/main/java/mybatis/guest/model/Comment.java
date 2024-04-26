package mybatis.guest.model;

import java.io.Serializable;

// 에전에는 마이바티즈에서 사용하려면 직렬화가 되어야만 함
public class Comment implements Serializable {
	/*
	 	디비 : _(snake case)로 이름 지정
	 	자바	: 낙타표기(camel case)로 이름 지정
	*/
	
	private int		commentNo;
	private String	userId;
	private String	commentContent;
	private String	regDate;
	
	// setter, getter
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
