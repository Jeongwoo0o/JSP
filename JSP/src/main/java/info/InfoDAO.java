package info;

import java.sql.*;
import java.util.*;

public class InfoDAO {
	
	private static InfoDAO instance;
	
	// DB 연결시  관한 변수  
	private static final String 	dbDriver	=	"com.mysql.cj.jdbc.Driver";
	private static final String		dbUrl		=	"jdbc:mysql://localhost:3306/basic";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";
		
		
	private InfoDAO() throws Exception {
		Class.forName( dbDriver );	
	}

	public static InfoDAO getInstance( ) throws Exception {
		if( instance == null )
		{
			instance = new InfoDAO();
		}
		return instance;
	}
}
