package schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleDAO {
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch(Exception e) {
			System.out.println("연결 문제 발생 : " + e);
		}
		return conn;
	}
	
	private void close() {	// 자주 사용되고 내용이 똑같거나, 일정구간만 다르다면 함수로 묶어서 처리하기
		try {
			if(rs != null) 		rs.close();
			if(pstmt != null) 	pstmt.close();
			if(conn != null) 	conn.close();
		} catch(Exception e) {}
	}
	
	public List<ScheduleDTO> selectAll() {
		ArrayList<ScheduleDTO> list = new ArrayList<>();
		String sql = "select * from schedule order by start_date asc";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ScheduleDTO dto = new ScheduleDTO();
				dto.setTitle(rs.getString("title"));
				dto.setStart_date(rs.getDate("start_date"));
				dto.setEnd_date(rs.getDate("end_date"));
				list.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally { close(); }
		
		return list;
	}

	public String selectVersion() {
		String version = null;	// 첫줄에 반환형의 변수를 만들어두고 (초기화 필요함)
		
		// DB에 접속해서 실행할 쿼리문
		String sql = "select banner from v$version";

		// 연결(conn)해서 sql을 실행(pstmt.executeQuery())하고 결과(rs)를 받아와야 한다
		try {
			conn = getConnection();				// 연결
			pstmt = conn.prepareStatement(sql);	// pstmt에 sql 적재(실행할 준비)
			rs = pstmt.executeQuery();			// 쿼리 실행 후 결과 받기
			
			while(rs.next()) {
				version = rs.getString("banner");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return version;			// 마지막줄에 해당 변수의 값을 반환한다
	}

	public Date selectSysdate() {
		Date sysdate = null;
		String sql = "select sysdate from dual";
		
		try {
			conn = getConnection();				// 연결해서 
			pstmt = conn.prepareStatement(sql);	// SQL을 실행할 준비
			rs = pstmt.executeQuery();			// 실행해서 결과 받기
			
			// 결과 안에 내가 원하는 데이터가 있다
			// 이 함수는 Date타입의 값을 반환해야 한다
			while(rs.next()) {
				sysdate = rs.getDate("sysdate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
 		} finally { close(); }
				
		return sysdate;
	}
	
	
	
	
	
	

}








