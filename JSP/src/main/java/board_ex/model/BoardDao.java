package board_ex.model;



import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import guest.model.Message;
import guest.model.MessageException;

public class BoardDao
{
	
	// Single Pattern 
	private static BoardDao instance;
	
	// DB 연결시  관한 변수 
	// [ 오라클 ]
	//private static final String 		dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	//private static final String		dbUrl		=	"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	//private static final String		dbUser		=	"scott";
	//private static final String		dbPass		=	"tiger";
	
	// [ MySQL / MariaDB ]
	private static final String 	dbDriver	=	"com.mysql.cj.jdbc.Driver";
	private static final String		dbUrl		=	"jdbc:mysql://localhost:3306/basic";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";
	
	
	private Connection	 		con;	
	
	//--------------------------------------------
	//#####	 객체 생성하는 메소드 
	public static BoardDao	getInstance() throws BoardException
	{
		if( instance == null )
		{
			instance = new BoardDao();
		}
		return instance;
	}
	
	private BoardDao() throws BoardException
	{
	
		try{
			
			/********************************************
			1. 오라클 드라이버를 로딩
				( DBCP 연결하면 삭제할 부분 )
		*/
			Class.forName( dbDriver );	
		}catch( Exception ex ){
			throw new BoardException("DB 연결시 오류  : " + ex.toString() );	
		}
		
	}
	
	/************************************************
	 * 함수명 : insert
	 * 역할 :	게시판에 글을 입력시 DB에 저장하는 메소드 
	 * 인자 :	BoardVO
	 * 리턴값 : 입력한 행수를 받아서 리턴
	*/
	public int insert( BoardVO rec ) throws BoardException
	{

		ResultSet rs = null;
		Statement stmt	= null;
		PreparedStatement ps = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			//* sql 문장 만들기
			String putQuery		= "INSERT INTO board_ex(writer, title, content, regdate, cnt, pass)  "
								+ "VALUES(?, ?, ?, date_format(now(), \'%Y%m%d%H%i%s\'), 0, ?)  ";  

			ps		= con.prepareStatement( putQuery );
			//* sql 문장의 ? 지정하기
			ps.setString(1, rec.getWriter());
			ps.setString(2, rec.getTitle());
			ps.setString(3, rec.getContent());
			ps.setString(4, rec.getPass());
	
			int insertedCount = ps.executeUpdate();			

			return insertedCount;
		
		}catch( Exception ex ){
			throw new BoardException("게시판 ) DB에 입력시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( stmt != null ) { try{ stmt.close(); } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		
	}
	
	/* -------------------------------------------------------
	 * 전체 레코드 수를 검색
	 */
	public int getTotalCount() throws BoardException{
		Connection	 		con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try{
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			// 2) sql 문장
			String sql = "SELECT COUNT(*) CNT  "
					   + "FROM board_ex  ";
			
			// 3) 전송객체
			ps = con.prepareStatement( sql );
			
			// 4) 전송
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("CNT");
			}

			return  count;
			
		}catch( Exception ex ){
			throw new BoardException("게시판 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}			
	}


	/************************************************
	 * 함수명 : selectList
	 * 역할 :	전체 레코드를 검색하는 함수
	 * 인자 :	없음
	 * 리턴값 : 테이블의 한 레코드를 BoardVO 지정하고 그것을 ArrayList에 추가한 값
	*/

	public List<BoardVO> selectList() throws BoardException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> mList = new ArrayList<BoardVO>();
		boolean isEmpty = true;
		
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			// * sql 문장만들기
			String sql = "SELECT *  "
					   + "FROM board_ex  "
					   + "ORDER BY seq DESC  ";
			// * 전송객체 얻어오기
			ps = con.prepareStatement( sql );
			// * 전송하기
			rs = ps.executeQuery();
			// * 결과 받아 List<BoardVO> 변수 mList에 지정하기
			while(rs.next()) { 
				isEmpty = false;
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("SEQ"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setRegdate(rs.getString("REGDATE")); 
				vo.setCnt(rs.getInt("CNT"));
				mList.add(vo); 
			}
			
			
			if( isEmpty ) return Collections.emptyList();
			
			return mList;
		}catch( Exception ex ){
			throw new BoardException("게시판 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
	
	//--------------------------------------------
	//#####	 게시글번호에 의한 레코드 검색하는 함수
	public BoardVO selectById(int seq) throws BoardException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		BoardVO rec = new BoardVO();
		
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			// * sql 문장만들기
			// * 전송객체 얻어오기
			// * 전송하기
			// * 결과 받아 BoardVO변수 rec에 지정하기

			
			return rec;
		}catch( Exception ex ){
			throw new BoardException("게시판 ) DB에 글번호에 의한 레코드 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}

	//--------------------------------------------
	//#####	 게시글 보여줄 때 조회수 1 증가
	public void increaseReadCount( int seq ) throws BoardException
	{

		PreparedStatement ps = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			// * sql 문장만들기
			// * 전송객체 얻어오기
			// * 전송하기
			
		}catch( Exception ex ){
			throw new BoardException("게시판 ) 게시글 볼 때 조회수 증가시 오류  : " + ex.toString() );	
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		
	}
	//--------------------------------------------
	//#####	 게시글 수정할 때
	public int update( BoardVO rec ) throws BoardException
	{

		PreparedStatement ps = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			// * sql 문장만들기
			// * 전송객체 얻어오기

			return ps.executeUpdate();
		
		}catch( Exception ex ){
			throw new BoardException("게시판 ) 게시글 수정시 오류  : " + ex.toString() );	
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		
	}
	
	
	//--------------------------------------------
	//#####	 게시글 삭제할 때
	public int delete( int seq, String pass ) throws BoardException
	{

		PreparedStatement ps = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
		
			// * sql 문장만들기
			// * 전송객체 얻어오기

			return ps.executeUpdate();
			
		}catch( Exception ex ){
			throw new BoardException("게시판 ) 게시글 수정시 오류  : " + ex.toString() );	
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		
	}
	
	/* -------------------------------------------------------
	 * 현재 페이지에 보여울 메세지 목록  얻어올 때
	 */
	public List<BoardVO> selectList(int firstRow, int endRow) throws BoardException
	{
		Connection	 		con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> mList = new ArrayList<BoardVO>();
		boolean isEmpty = true;
		
		try{
			// 1) 연결객체
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
						
			// 2) sql 문장
			String sql = "SELECT e.*  "
					   + "FROM  "
					   + "	(  "
					   + "		SELECT *  "
					   + "		FROM board_ex  "
					   + "		ORDER BY SEQ DESC  "
					   + "	) e  "
					   + "LIMIT ?, ?  ";
						
			// 3) 전송객체
			ps = con.prepareStatement( sql );
			ps.setInt(1, firstRow);
			ps.setInt(2, endRow);	
			
			// 4) 전송
			rs = ps.executeQuery();
			
						
			
			while(rs.next()) { 
				isEmpty = false;
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("SEQ"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setRegdate(rs.getString("REGDATE")); 
				vo.setCnt(rs.getInt("CNT"));
				mList.add(vo); 
			}			

			
			if( isEmpty ) return Collections.emptyList();
			
			return mList;
		}catch( Exception ex ){
			throw new BoardException("게시판 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
	
	
}