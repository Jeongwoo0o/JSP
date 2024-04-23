package guest.model;

public class Message {
	private int 	messageId;	// 메세지번호
	private String 	guestName;	// 작성자
	private String	password;	// 비밀번호
	private String	message;	// 메세지
	
	// setter, getter
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", guestName=" + guestName + ", password=" + password + ", message="
				+ message + "]";
	}
}
