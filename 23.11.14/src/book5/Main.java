package book5;

import java.util.Scanner;

public class Main {	
	// case2의 입력부분, Scanner를 매개변수로 전달받아서 객체를 생성하고, 
	// 사용자 입력값으로 객체를 구성하여 그 객체를 반환하는 함수
	static Book getBookFromUserInput(Scanner sc) {
		Book book = new Book();
		
		String name, author, publisher; // Book의 String 타입 필드 (입력 받기 위한 값)
		int price; // Book의 int 타입의 필드 (입력받기 위한 값)
		
		System.out.println("도서 이름 입력 :");
		name = sc.nextLine();
		
		System.out.println("도서 작가 입력 :");
		author = sc.nextLine();
		
		System.out.println("도서 출판사 입력 :");
		publisher = sc.nextLine();
		
		System.out.println("도서 가격 입력 :");
		price = Integer.parseInt(sc.nextLine());
		
		book.setAuthor(author);
		book.setName(name);
		book.setPrice(price);
		book.setPublisher(publisher);
		
		return book;
	}
	
	// 도서 이름을 전달받아서, 배열 안에서 일치하는 객체를 찾아서 삭제하는 함수
	
	
	public static void main(String[] args) {// 사용자 입출력
		// 변수 선언
		Handler handler = new Handler();
		Scanner sc = new Scanner(System.in); // 입력받기 위한 Scanner
		Book book = null;	// 추가 수정 삭제 검색에서 사용할 객체를 받기 위한 변수
		int row = 0;		// 추가 및 삭제가 정상적으로 수행되었는지 확인하기 위한 변수
		String name;
//		String author, publisher; // Book의 String 타입 필드 (입력 받기 위한 값)
//		int price; // Book의 int 타입의 필드 (입력받기 위한 값)
//		Book[] arr = new Book[10]; // 여러 Book 객체를 저장하기 위한 배열
									// 배열은 자료형에 맞는 0값으로 초기화된다
									// 참조형 변수(클래스 타입 변수)의 초기값은 null;
//		arr[] = {null,null...null}		null 10개
	
		int menu = -1; // switch와 연동하기 위한 메뉴

		// 입력 및 출력 (자료형 + 대입, 제어문 + 연산자 활용)
		handler.load();
		while (menu != 0) {
			// 사용자 메뉴 출력
			System.out.println("1.목록 :");
			System.out.println("2.추가 :");
			System.out.println("3.삭제 :");
			System.out.println("0.종료");
			System.out.println("메뉴 입력 >>>");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) { // 사용자가 입력한 메뉴에 따라서 서로 다른 코드를 수행한다(분기문)
			case 1: // 1.전체 목록
				handler.showList();
				break;

			case 2: // 2.도서 추가
				book = getBookFromUserInput(sc);
				row = handler.insertBook(book);
				System.out.println(row != 0 ? "추가 성공" : "추가 실패");
				break;// 추가하고 나서 break가 없으면 case 0으로 넘어가니까 switch의 break
			
			case 3:
				// 배열 내부의 도서 중에서 이름이 일치하는 객체를 찾아서 제거한다
				System.out.println("검색어를 입력하세요: ");
		name = sc.nextLine();
				row = handler.deleteBook(name);
				System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
				break;
			
			case 0:// 종료하기 전에 저장하고 종료한다
	handler.save();
				System.out.println("프로그램 종료");
				break;
			}
		}
		//마무리 종료
		sc.close();
	} // end of main(0
} // end of class
