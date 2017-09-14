package ssl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ssl.dto.BoardDTO;

public class BoardDAO
{
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getinstance()
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

	public int writeSS(BoardDTO dto, String writer_day) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into ss_board values(ss_no_seq.nextval, ?, ?, ?, ?, ?, default, default, default)";
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUser_no());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getWriter_comment());
			pstmt.setString(4, dto.getMain_content());
			pstmt.setString(5, writer_day);
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
		return result;
	}
	
	public ArrayList<BoardDTO> getAllBoardList()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ss_board";
		BoardDTO dto = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				dto = new BoardDTO(rs.getInt("ss_no"), rs.getInt("user_no"), rs.getString("title"),
						rs.getString("writer_comment"), rs.getString("main_content"), rs.getString("writer_day"),
						rs.getInt("hits"), rs.getInt("recommend"), rs.getInt("visiable"));
				
				list.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		return list;
	}

	public BoardDTO getOneSS(int ss_no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ss_board where ss_no = ?";
		BoardDTO dto = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ss_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				dto = new BoardDTO(rs.getInt("ss_no"), rs.getInt("user_no"), rs.getString("title"),
						rs.getString("writer_comment"), rs.getString("main_content"), rs.getString("writer_day"),
						rs.getInt("hits"), rs.getInt("recommend"), rs.getInt("visiable"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return dto;		
	}
	
	public void modifySS(BoardDTO dto, int ss_no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update ss_board set title=?, writer_comment=?, main_content=? where ss_no = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter_comment());
			pstmt.setString(3, dto.getMain_content());
			pstmt.setInt(4, ss_no);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
	}
	
	// Search 폼 사용할 때
	public ArrayList<BoardDTO> getOneBoardList(String search)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ss_board where title like ?";
		BoardDTO dto = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			String searchValue = "%" + search + "%";
			pstmt.setString(1, searchValue);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				dto = new BoardDTO(rs.getInt("ss_no"), rs.getInt("user_no"), rs.getString("title"),
						rs.getString("writer_comment"), rs.getString("main_content"), rs.getString("writer_day"),
						rs.getInt("hits"), rs.getInt("recommend"), rs.getInt("visiable"));
				
				list.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}		
		return list;
	}
	
	public int getSS_no(int user_no, String title)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ss_no = 0;
		
		String sql = "select * from (select * from ss_board where user_no = ? and title = ? order by ss_no desc) where rownum=1";
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_no);
			pstmt.setString(2, title);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) ss_no = rs.getInt("ss_no");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return ss_no;
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
