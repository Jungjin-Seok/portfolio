package schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Handler handler = new Handler();
		SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date date = null;	// java.util.Date는 java.sql.Date의 슈퍼클래스이다
		List<ScheduleDTO> list = null;
		int menu = -1;
		
		// select sysdate from dual
		// getDate("sysdate")
		Date now = handler.getSysdate(); 	// 좌변과 우변의 자료형은 같아야 한다
		
		while(menu != 0) {
			System.out.println("=== DB기준 현재 날짜 ===");
			System.out.println(now);
			System.out.println("=====================");
			System.out.println("1. 전체 출력");
			System.out.println("2. 월별 검색");
			System.out.println("3. 일정 등록");
			System.out.println("4. 일정 삭제");
			System.out.println("0. 종료");
			System.out.print("선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 123:
				// 오라클 데이터베이스 버전 정보를 문자열로 출력하기
				// select banner from v$version
				String version = handler.getVersion();	// 버전을 문자열로 불러와서
				System.out.println(version);			// 출력
				break;
				
			case 1:
				list = handler.selectAll();
				for(ScheduleDTO ob : list) {
					System.out.printf("%s : %s ~ %s\n",
							ob.getTitle(), 
							ob.getStart_date(), 
							ob.getEnd_date());
				}
				break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 0: break;
			}
		}	// end of while
		sc.close();
	}
}
