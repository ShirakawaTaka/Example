package ssl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import ssl.dto.UserDTO;

public class UserDAO
{
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getinstance()
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
	
	// 회원 가입
	public boolean joinUser(UserDTO user)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into ss_user values(user_no_seq.nextval,?,?,?,default,default)";
		boolean returnValue = false;
		
		try
		{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getNickname());

			int result = pstmt.executeUpdate();
			if(result > 0)
			{
				returnValue = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		
		return returnValue;
	}

	// 유저 한명의 정보를 가져오는 메소드
	public UserDTO getOneUser(String email)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select user_no, email, nickname, visiable, admin from ss_user where email = ?";
		UserDTO dto = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			System.out.println("겟유저 쿼리 성공");
			if(rs.next())
			{
				dto = new UserDTO(rs.getInt("user_no"), rs.getString("email"), rs.getString("nickname"), rs.getInt("visiable"), rs.getInt("admin"));
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		return dto;
	}
	
	// 로그인 체크
	public int loginCheck(String email, String pass)
	{
		int result = -1; 
		// -1 : 아이디 다름
		// 0 : 비밀번호가 다름
		// 1 : 로그인 성공
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select password from ss_user where email=?";
		
		try
		{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();

			if(rs.next()) // 쿼리 성공 체크
			{ 
				if(rs.getString("password").equals(pass)) 
				{ // 성공했다면 db비번과 입력받은 비번을 비교
					System.out.println("일치");
					result = 1;
				}else 
				{ // 비번이 맞지 않을 시 0 반환 
					System.out.println("비번불일치");
					result = 0;
				}
			}else // 쿼리 결과가 없다면 id값이 잘못 됨.
			{ 
				System.out.println("아이디불일치");
				result = -1;
			}			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			close(rs, pstmt, conn);
		}
		return result;
	}
	

	public int modifyUser(UserDTO dto, int user_no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update ss_user set email=?, password=?, nickname=? where user_no = ?";
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getNickname());
			pstmt.setInt(4, user_no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		
		return result;
	}
	
	public int deleteUser(int user_no, int visiable)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update user set visiable=? where user_no=?";
		int result = 0;		
		try
		{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, visiable);
			pstmt.setInt(2, user_no);
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
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
