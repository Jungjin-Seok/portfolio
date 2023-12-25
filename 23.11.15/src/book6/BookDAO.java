package book6;

import java.sql.*; //자바에서 DB에 접속하기 위한 클래스를 가져온다
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;
// Oracle전용 접속 드라이버는 라이브러리 파일을 가져와야한다

public class BookDAO {

	private Connection conn;	// 접속 1단계, 네트워크 및 포트 접속을 확인한다
//	private Statement stmt;		// 접속 2단계, 접속된 DB프로그램이 작업을 수행할 수 있는 상태인지 확인
	private PreparedStatement pstmt; // Statement의 서브클래스(상속) pstmt
	private ResultSet rs;		// 만약 수행하는 쿼리가 select이면 결과를 받아서 저장한다
								// insert, update, delete는 결과를 int 형태로 반환한다

	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String username = "c##itbank";
	private String password = "it";
	
	public BookDAO() {
		try {
		Class.forName(OracleDriver.class.getName());	
		conn = DriverManager.getConnection(url, username,password);
		//if(conn == null{
		// 		throw new SQLException("DB에 접속할 수 없습니다);
		//
		
	} catch (SQLException e) {
		System.out.println("SQL 접속 예외 : " + e);
		e.printStackTrace();
		
	} catch (ClassNotFoundException e) {
		System.out.println("클래스를 불러올 수 없습니다: " + e);
		e.printStackTrace();
	}
  }
	
	// 전체 목록 불러오기
	public ArrayList<BookDTO> selectList() {
	// conn -> stmt -> rs/row (문자를 반환 : rs, 정수를 반환 : row)
		ArrayList<BookDTO> list = new ArrayList<>(); // 리스트 생성
		String sql = "select * from book";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setAuthor(rs.getString("author"));	// 컬럼 이름을 지정해서 문자열로 불러온다
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));	// 정수로 불러오고 싶으면 getInt
				dto.setPublisher(rs.getString("publisher"));
				list.add(dto);	// DB에서 불러온 데이터를 리스트에 채우기
			}
		
		} catch (SQLException e) {
			System.out.println("selectlist 예외 발생 :" + e);
			e.printStackTrace();
		} finally { // 예외 발생 여부에 상관없이
			try {
				if(rs != null) rs.close();	// 통로 개설의 역순으로 닫아준다
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
		return list;	// 리스트 반환
	}

	// 전달받은 객체를 DB에 저장하기
	public int insertBook(BookDTO dto) {
		int row = 0;
//		String sql = "insert into book values()";
		// 쿼리문에 내가 값을 입력해야 하는 내용이 많으면
		// 따옴표 처리 및 자료형 처리가 불편해진다
		// 기존의 Statement는 이런 기능이 없어서
		// PreparedStatement를 이용하면 순서대로 값을 넣을 수 있는데
		// 사용하는 형식은 printf()와 유사하다
		String sql = "insert into book values(?, ?, ?, ?)";	// 쿼리문 형식만 준비
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());	// setString은 따옴표처리도 자동으로 수행한다
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getPublisher());
			pstmt.setInt(4, dto.getPrice());	//setInt는 따옴표를 처리하지 않는다
			row = pstmt.executeUpdate();	// insert/update/delete를 수핸하고 int로 받는다
		} catch (SQLException e) {
			System.out.println("insertBook 예외 발생 :" + e);
			e.printStackTrace();
		} finally { // 예외 발생 여부에 상관없이 실행한다
			try {
				if(rs != null) rs.close();	// 통로 개설의 역순으로 닫아준다
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
		return row;		
	}

	// 전달받은 객체를 DB에서 삭제하기
	public int deleteBook(String name) {
		int row = 0;
		String sql = "delete book where name = ?";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			row = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {	// 예외 발생 여부에 상관없이
			try {
				if(rs != null) rs.close();	// 통로 개설의 역순으로 닫아준다
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
		return row;
	}
	
}
