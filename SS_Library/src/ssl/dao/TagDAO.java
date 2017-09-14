package ssl.dao;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TagDAO
{
	private TagDAO() {}
	private static TagDAO instance = new TagDAO();
	public static TagDAO getinstance()
	{
		return instance;
	}
	
	public Connection getConnection() throws Exception
	{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/dbcp");
		conn = ds.getConnection();
		
		return conn;
	}

	public boolean isTag(String tag) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		
		String sql = "select * form ss_tags where tag_name = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return result;
	}
	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{
		if(rs!=null) // ResultSet 있을 경우
		{
			try 
			{
				rs.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		if(pstmt!=null)  // PreparedStatement 있을 경우
		{
			try
			{
				pstmt.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		if(conn!=null) // Connection 있을 경우
		{
			try 
			{
				conn.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
