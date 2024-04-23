package temp;

import java.sql.*;
import java.util.*;

public class EmpDao {

	private static EmpDao  instance;
	
	// DB 연결시  관한 변수  
	private static final String 	dbDriver	=	"com.mysql.cj.jdbc.Driver";
	private static final String		dbUrl		=	"jdbc:mysql://localhost:3306/basic";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";
		
		
	private EmpDao() throws Exception {
		Class.forName( dbDriver );	
	}
	
	public static EmpDao getInstance( ) throws Exception {
		if( instance == null )
		{
			instance = new EmpDao();
		}
		return instance;
	}
	
	public void insertEmp(EmpVO vo) throws Exception {
		Connection			con 	= null;	
		ResultSet 			rs 		= null;
		Statement 			stmt	= null;
		PreparedStatement 	ps 		= null;
		try{
			// 1. 연결객체 얻어오기
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			// 2. sql 문장 만들기
			String sql		= "INSERT INTO emp(empno, ename, deptno, job, sal)  "
							+ "VALUES(?, ?, ?, ?, ?)  ";  
			
			// 3. 전송객체 얻어오기 + ? 지정
			ps	= con.prepareStatement( sql );
			ps.setInt(1, vo.getEmpno());
			ps.setString(2, vo.getEname());
			ps.setInt(3, vo.getDeptno());
			ps.setString(4, vo.getJob());
			ps.setInt(5, vo.getSal());
			
			// 4. 전송하기
			ps.executeUpdate();
			
		}catch( Exception ex ){
			throw new Exception("사원정보 ) DB에 입력시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( stmt != null ) { try{ stmt.close(); } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
	
	public List<EmpVO> selectEmp() throws Exception {
		List<EmpVO> list = new ArrayList<EmpVO>();
		Connection			con 	= null;	
		Statement 			stmt	= null;
		PreparedStatement 	ps 		= null;
		ResultSet 			rs 		= null;
		
		// 1) 연결객체
		try {
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			// 2) sql 문장
			String sql = "SELECT empno, ename, job, sal, deptno  "
					   + "FROM emp  ";
			
			// 3) 전송객체
			ps = con.prepareStatement( sql );
			
			// 4) 전송
			rs = ps.executeQuery();
			
			// 5) 결과집합을 받아서 List<EmpVO>에 지정하기
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setSal(rs.getInt("sal"));
				vo.setDeptno(rs.getInt("deptno"));
				list.add(vo);
			}
			
		}finally {
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( stmt != null ) { try{ stmt.close(); } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		return list;
	}
	
	/*
 		함수명 	:
 		인자		:
 		리턴값	:
 		역할		:
	*/
	public boolean loginCheck(EmpVO vo) throws Exception {
		Connection			con 	= null;	
		Statement 			stmt	= null;
		PreparedStatement 	ps 		= null;
		ResultSet 			rs 		= null;
		boolean 			result	= false;
		
		// 1) 연결객체
		try {
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			// 2) sql 문장
			String sql = "SELECT * FROM emp  "
					   + "WHERE ename=? AND empno=?  ";
			
			// 3) 전송객체
			ps = con.prepareStatement( sql );
			
			ps.setString(1, vo.getEname());
			ps.setInt(2, vo.getEmpno());
			
			// 4) 전송
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			} else {
				result = false;
			}
			
		}finally {
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( stmt != null ) { try{ stmt.close(); } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		return result;
	}
	
}
