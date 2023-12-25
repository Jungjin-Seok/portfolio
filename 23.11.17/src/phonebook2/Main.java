package phonebook2;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
	    Scanner sc = new Scanner(System.in);
		Handler handler = new Handler();
		List<Phonebook2DTO> list = null;
		Phonebook2DTO ob = null;
		int menu = -1;
		String name, pnum;
		int idx;
		int row;
		
		while(menu != 0) {
			System.out.println("메뉴 출력");
			System.out.println("1. 전체목록");
			System.out.println("2. 추가");
			System.out.println("3. 전화번호 수정");
			System.out.println("4. 즐겨찾기 수정");
			System.out.println("5. 삭제");
			System.out.println("0. 종료");
			System.out.println("입력 >>>>");
			menu = Integer.parseInt(sc.nextLine());
		
			switch(menu) {
				case 1:
					handler.showList();
					break;
		
				case 2:
					ob = getBookFromUserInput(sc);
					row = handler.insertPhonebook2(ob);
					System.out.println(row != 0 ? "추가 성공" : "추가 실패");
					break;
		
				case 3:
					System.out.println("전화 번호를 수정합니다");
					System.out.print("이름을 입력 :");
					name = sc.nextLine();
					System.out.println("수정할 전화번호를 입력 :");
					pnum = sc.nextLine();
					row = handler.updatePnum(name, pnum);
					System.out.println(row != 0 ? "수정 완료" : "수정 실패");
					break;
		
				case 4:
			
					break;
		
				case 5:
			
					break;
		
				case 0:
			
					break;
			
		}
	}
		sc.close();
 
 }

	private static Phonebook2DTO getBookFromUserInput(Scanner sc) {
		// TODO Auto-generated method stub
		return null;
	}
}
