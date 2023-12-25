package youtube;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class YouTubeDAO {

	private String url="jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user="c##itbank";
	private String password="it";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	// getConnection
	private Connection getConnection() throws Exception {
		Class.forName(OracleDriver.class.getName());
		return DriverManager.getConnection(url,user,password);
	}
	
	// close
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
	
		}	
	}
	
	
	
	// mapping
	private YouTubeDTO mapping(ResultSet rs) throws SQLException {
		YouTubeDTO dto = new YouTubeDTO();
		dto.setTitle(rs.getString("title"));
		dto.setChName(rs.getString("chName"));
		dto.setImgName(rs.getString("imgName"));
		dto.setVideoTag(rs.getString("videoTag"));
		dto.setCategory(rs.getString("category"));
		return dto;
	}
	
	//전체목록
	public List<YouTubeDTO> selectList() {
		ArrayList<YouTubeDTO> list = new ArrayList<YouTubeDTO>();
		String sql ="select * from youtube";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//단일목록
	public List<YouTubeDTO> selectListBycategory() {
		ArrayList<YouTubeDTO> list = new ArrayList<YouTubeDTO>();
		String sql ="select * from youtube where category = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//추가
	public int insert(YouTubeDTO dto) {
		int row = 0;
		String sql = "insert into youtube (title, chName, imgName, videoTag, category) values( ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getChName());
			pstmt.setString(3, dto.getImgName());
			pstmt.setString(4, dto.getVideoTag());
			pstmt.setString(5, dto.getCategory());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return row;
	}
	//삭제
	public int delete(int idx) {
		int row = 0;
		String sql = "delete youtube where idx = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return row;
	}
	//수정
	public int update(YouTubeDTO dto) {
		int row = 0;
		String sql = "update youtube"
					+ " set"
					+ "		title = ?"
					+ "		chName = ?"
					+ "		imgName = ?"
					+ "		videoTag = ?"
					+ "		category = ?"
					+ "	where"
					+ "		idx = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getChName());
			pstmt.setString(3, dto.getImgName());
			pstmt.setString(4, dto.getVideoTag());
			pstmt.setString(5, dto.getCategory());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return row;
	}
	
		// 마지막 시퀀스 번호
		public int selectCurrseq() {
			int idx = 0;
			String sql = "select max(idx) from youtube";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					idx = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			} 
			return idx;
		}
	
}
