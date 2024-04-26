package mybatis.guest.session;

import java.io.*;
import java.util.*;

import mybatis.guest.model.Comment;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class CommentRepository 
{
	//	private final String namespace = "CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() {
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	
	/*
	 	JDBC 	: Connection (연결)
	 	mybatis : SqlSession
	*/
	public List<Comment> selectComment() {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			List<Comment> list = sess.selectList("CommentMapper.selectComment");
			return list;
		} finally {
			sess.close();	// 연결객체를 반환
			// 내부적으로 mybatis는 ConnectionPool 사용
		}
	}
	
	public List<Comment> selectComment(HashMap condition) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			List<Comment> list = sess.selectList("CommentMapper.selectComment", condition);
			return list;
		} finally {
			sess.close();	// 연결객체를 반환
			// 내부적으로 mybatis는 ConnectionPool 사용
		}
	}
	
	public void insertComment(Comment comment) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			// **************
			/*
			 	JDBC	: auto commit
			 	mybatis : manual commit
			*/
			int result = sess.insert("CommentMapper.insertComment", comment);
			
			if(result == 1) {
				sess.commit();
			}else {
				sess.rollback();
			}
		} finally {
			sess.close();	// 연결객체를 반환
			// 내부적으로 mybatis는 ConnectionPool 사용
		}
	}
	
	public void updateComment(Comment comment) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			int result = sess.update("CommentMapper.updateComment", comment);
			
			if(result == 1) {
				sess.commit();
			}else {
				sess.rollback();
			}
		} finally {
			sess.close();	// 연결객체를 반환
			// 내부적으로 mybatis는 ConnectionPool 사용
		}
	}
	
	public Comment selectCommentByPK(int commentNo) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			HashMap map = new HashMap();
			map.put("commentNo", commentNo);
			
			Comment comment = sess.selectOne("CommentMapper.selectComment", map);
			return comment;
		} finally {
			sess.close();
		}
	}
	
	public void deleteComment(int commentNo) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			int result = sess.delete("CommentMapper.deleteComment", commentNo);
			
			if(result > 0) {
				sess.commit();
			}
		} finally {
			sess.close();
		}
	}
}
