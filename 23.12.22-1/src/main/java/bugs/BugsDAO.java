package bugs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BugsDAO {
	// 싱글톤 (DAO 객체가 여러개일 필요가 없다)
	private static BugsDAO instance = new BugsDAO();
	public static BugsDAO getInstance() {
		return instance;
	}
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;	// context.xml 에서 작성한 내용대로의 객체를 포함하는 컨테이너
	private DataSource ds;	// 여러 커넥션을 관리하는 DataSource 객체
	// 커넥션 풀 : 요청이 들어올때 마다 새로운 커넥션을 사용하지 말고
	//			 미리 충분히 사용할 만큼의 커넥션을 생성해두고, 돌려가면서 사용하기 위해서

	private BugsDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
			
		} catch (NamingException e) {
			System.out.println("지정한 이름의 객체를 찾을 수 없습니다: " + e );
		}	finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}

		// 내부함수
		// void close
		private void close() {
			try {
				if(rs != null) 		rs.close();
				if(pstmt != null) 	pstmt.close();
				if(conn != null) 	conn.close();
			} catch (Exception e) {}
		}
		
		// void mapping
		private BugsDTO mapping(ResultSet rs) throws SQLException {
			BugsDTO dto = new BugsDTO();
			dto.setId(rs.getInt("id"));
			dto.setArtist_name(rs.getString("artist_name"));
			dto.setArtist_img(rs.getString("artist_img"));
			dto.setAlbum_name(rs.getString("album_name"));
			dto.setAlbum_img(rs.getString("album_img"));
			dto.setName(rs.getString("name"));
			dto.setGenre(rs.getString("genre"));
			dto.setPlayTime(rs.getInt("playTime"));
			dto.setLyrics(rs.getString("lyrics"));
			dto.setIsTitle(rs.getInt("isTitle"));
			return dto;
		}
		
		// List<BugsDTO> selectAll()
		// - select * form bugs order by artist_name, id
		public List<BugsDTO> selectAll(String search){
			ArrayList<BugsDTO> list = new ArrayList<>();
			String sql = "select * from bugs"
						+ "	where"
						+ "		name like '%' || ? || '%'"
						+ "		or"
						+ "		artist_name like '%' || ? || '%'"
						+ " 	order by artist_name, id";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				rs = pstmt.executeQuery();
				while(rs.next()){
					BugsDTO dto = mapping(rs); 
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally { close();}
			System.out.println("불러온 목록의 개수" + list.size());
			return list;
		}


		// 상세조회
		public BugsDTO selectOne(int id) {
			BugsDTO dto = null;;
			String sql="select * from bugs where id =?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					dto = mapping(rs);
					return dto;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {close();}
			return dto;
			
		}


		// 추가

		// 삭제
		public int delete(int id) {
			int row = 0;
			String sql = "delete from bugs where id = ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				row = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {close();}
			return row;
		}
		
		/*  
		 	// 삭제
		 	 *  public // 외부에서 호출해야 하니까 public
		 	 *  int		// delete쿼리는 영향을 받은 줄 수를 반환
		 	 *	delete(int id) { //id를 정수로 전달 받는다
		 	 *	int row = 0 // 반환형 변수 선언
		 	 *	String sql = "delete from bugs where id = ?";
		 	 *	try {
		 	 *		conn = ds.getConnection();
		 	 *		pstmt = conn.prerparsStatement(sql);
		 	 *		pstmt.setInt(1 , id);
		 	 *				sql이 select이면 executeQuery() --- ResultSet
		 	 *				sql이 insert/ delete/ update 면 exeupteUpdate() --- int
		 	 *		row = pstmt.excuteUpdate(); 
		 	 *	} catch (SQLException e) {
				e.printStackTrace();
			} finally {close();}
			return row;
		}
		 */
		// 수정
		

}
