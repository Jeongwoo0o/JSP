package reply_ex.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import board_ex.model.BoardException;
import board_ex.model.BoardVO;

public class ReplyDao {
	private static ReplyDao instance;
	
	private static final String 	dbDriver	=	"com.mysql.cj.jdbc.Driver";
	private static final String		dbUrl		=	"jdbc:mysql://localhost:3306/basic";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";
	
	private Connection con;
	
	public static ReplyDao	getInstance() throws ReplyException
	{
		if( instance == null )
		{
			instance = new ReplyDao();
		}
		return instance;
	}
	
	private ReplyDao() throws ReplyException
	{
	
		try{
			Class.forName( dbDriver );	
		}catch( Exception ex ){
			throw new ReplyException("DB 연결시 오류  : " + ex.toString() );	
		}
		
	}
	
	// 데이터베이스에 댓글 입력
	public int insertReply( ReplyVO vo ) throws ReplyException
	{

		ResultSet rs = null;
		Statement stmt	= null;
		PreparedStatement ps = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			//* sql 문장 만들기
			String sql = "INSERT INTO reply_ex(seq, user, reply)  "
					   + "VALUES(?, ?, ?)  ";  

			ps = con.prepareStatement( sql );
			//* sql 문장의 ? 지정하기
			ps.setInt(1, vo.getSeq());
			ps.setString(2, vo.getUser());
			ps.setString(3, vo.getReply());
	
			int insertedCount = ps.executeUpdate();			

			return insertedCount;
		
		}catch( Exception ex ){
			throw new ReplyException("댓글 ) DB에 입력시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( stmt != null ) { try{ stmt.close(); } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		
	}
	
	// 데이터베이스에서 댓글 가져오기
	public List<ReplyVO> selectList() throws ReplyException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReplyVO> mList = new ArrayList<ReplyVO>();
		boolean isEmpty = true;
		
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			// * sql 문장만들기
			String sql = "SELECT *  "
					   + "FROM reply_ex  "
					   + "ORDER BY REPLY_ID DESC  ";
			// * 전송객체 얻어오기
			ps = con.prepareStatement( sql );
			// * 전송하기
			rs = ps.executeQuery();
			// * 결과 받아 List<BoardVO> 변수 mList에 지정하기
			while(rs.next()) { 
				isEmpty = false;
				ReplyVO vo = new ReplyVO();
				vo.setReply_id(rs.getInt("REPLY_ID"));
				vo.setSeq(rs.getInt("SEQ"));
				vo.setUser(rs.getString("USER"));
				vo.setReply(rs.getString("REPLY"));
				mList.add(vo); 
			}
			
			
			if( isEmpty ) return Collections.emptyList();
			
			return mList;
		}catch( Exception ex ){
			throw new ReplyException("댓글 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
}
