package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	// 싱글톤
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	private MemberDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
		if(conn != null) try {conn.close();} catch(SQLException e) {}	
		}
	}
	
	private void close() {
			try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	private MemberDTO mapping(ResultSet rs) throws SQLException {
		MemberDTO dto = new MemberDTO();
		dto.setUserId(rs.getString("userId"));
		dto.setUserPw(rs.getString("userPw"));
		dto.setUserName(rs.getString("userName"));
		dto.setEmail(rs.getString("email"));
		dto.setGender(rs.getString("gender"));
		return dto;
	}
	
	// 전체 및 단일 검색
	public List<MemberDTO> selectAll(String search) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql ="select * from Member where username like '%'|| ? || '%' order by userid, email";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = mapping(rs);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 회원가입
	public int insert(MemberDTO dto) {
		int row = 0;
		String sql = "insert into member (userId, userPw, userName, email, gender) values(?, ?, ?, ?, ?) ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPw());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getGender());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {close();}
		return row;
	}
	
	
}
