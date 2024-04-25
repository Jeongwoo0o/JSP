package reply_ex.model;

public class ReplyVO {
	private int 	reply_id;	// 댓글번호
	private int 	seq;		// 게시글번호
	private String 	user;		// 사용자명
	private String  reply;		// 내용
	
	// setter, getter
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [reply_id=" + reply_id + ", seq=" + seq + ", user=" + user + ", reply=" + reply + "]";
	}
}
