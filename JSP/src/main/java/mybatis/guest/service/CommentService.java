package mybatis.guest.service;

import java.util.*;

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;

public class CommentService {
	
	private static CommentService service;
	
	private CommentService() {}
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}
	
	CommentRepository repo =  new CommentRepository();
	
	public List<Comment> selectComment() {
		List<Comment> list = repo.selectComment();
		return list;
	}
	
	public List<Comment> selectComment(HashMap condition) {
		List<Comment> list = repo.selectComment(condition);
		return list;
	}
	
	public void insertComment(Comment comment) {
		repo.insertComment(comment);
	}
	
	public void updateComment(Comment comment) {
		repo.updateComment(comment); 
	}
	
	public Comment selectCommentByPK(int commentNo) {
		Comment comment = repo.selectCommentByPK(commentNo);
		return comment;
	}
	
	public void deleteComment(int commentNo) {
		repo.deleteComment(commentNo);
	}
}