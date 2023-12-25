package phonebook2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Phonebook2DAO{

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
//	public Phonebook2DAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(url, user, password);
//			
//		} catch (SQLException  | ClassNotFoundException e) {
//			System.out.println("생성자 예외 발생 :" + e);
//			e.printStackTrace();
//		}
//	}
//
//	// 전체 목록 불러오기
//	public ArrayList<Phonebook2DTO> selectList() {
//		ArrayList<Phonebook2DTO> list = new ArrayList<>();
//		String sql = "select * from book order by favorite desc, name";
//		
//		pstmt = conn.prepareStatement(sql);
//		rs = pstmt.executeQuery();
//
//		while(rs.next()) {
//			Phonebook2DTO dto = new Phonebook2DTO();
//			dto.setIdx(rs.getInt("idx"));
//			dto.setAge(rs.getInt("age"));
//			dto.setFavorite(rs.getString("favorite"));
//			dto.setName(rs.getString("name"));
//			dto.setPnum(rs.getString("pnum"));
//			list.add(dto);
//		}
//		rs.close();
//		pstmt.close();
//		conn.close();
//		return list;
//	}
	
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public ArrayList<Phonebook2DTO> selectList() throws Exception {
		ArrayList<Phonebook2DTO> list = new ArrayList<>();
		String sql = "select * from phonebook2 order by favorite desc, name asc";
		
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			//  RowMapper 에 작성했던 규칙을 여기에 작성
			Phonebook2DTO dto = new Phonebook2DTO();
			dto.setAge(rs.getInt("age"));
			dto.setFavorite(rs.getString("favorite"));
			dto.setIdx(rs.getInt("idx"));
			dto.setName(rs.getString("name"));
			dto.setPnum(rs.getString("pnum"));
			list.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	public int insertPhonebook2(Phonebook2DTO ob) throws SQLException {
		int row = 0;
		String sql = "insert into phonebook2 value (?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1 , ob.getName());
		pstmt.setString(2 , ob.getPnum());
		pstmt.setInt(3, ob.getAge());
		pstmt.setString(4, ob.getFavorite());
		return row;
	}

	
	


	
	
	
	
	
	
	
	
	
	
}
