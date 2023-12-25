package book1;

import java.util.Scanner;

public class Ex01 {
	static void showList(Book[] arr) {
	// 배열을 전달받아서, 배열 내부의 각 객체를 서식에 맞게 출력하는 함수 (case 1을 가져옴)
	// 함수의 인자와 매개 변수를 생각해야한다
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) { // 배열의 각 초기값 null을 처리(회피)하기 위한 if
				System.out.printf("%s(%s,%s) : %d원\n", arr[i].getName(), arr[i].getAuthor(), arr[i].getPublisher(), arr[i].getPrice());
				
			}
		}
	}
	
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
	static int deleteBook(String name, Book[] arr) {
		int row = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].getName().equals(name)) {
				arr[i] = null; 	// 참조변수가 객체를 참조하지 않도록 한다
								// 모두에게서 잊혀진 참조변수는 소멸한다						
				row = 1;		// 삭제했다는 결과를 반환하기 위해 row값을 1로 설정한다
				break;			// 하나 지웠으면 중단한다.
			}
		}
		return row;
	}
	
	public static void main(String[] args) {// 사용자 입출력
		// 변수 선언
		Book book = null;	// 추가 수정 삭제 검색에서 사용할 객체를 받기 위한 변수
		int row = 0;		// 추가 및 삭제가 정상적으로 수행되었는지 확인하기 위한 변수
		String name;
//		String author, publisher; // Book의 String 타입 필드 (입력 받기 위한 값)
//		int price; // Book의 int 타입의 필드 (입력받기 위한 값)
		Scanner sc = new Scanner(System.in); // 입력받기 위한 Scanner
		Book[] arr = new Book[10]; // 여러 Book 객체를 저장하기 위한 배열
									// 배열은 자료형에 맞는 0값으로 초기화된다
									// 참조형 변수(클래스 타입 변수)의 초기값은 null;
//		arr[] = {null,null...null}		null 10개
	
		int menu = -1; // switch와 연동하기 위한 메뉴

		// 입력 및 출력 (자료형 + 대입, 제어문 + 연산자 활용)
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
				showList(arr);
				break;

			case 2: // 2.도서 추가
				book = getBookFromUserInput(sc);
				
				// 4개의 값을 입력을 받았다면 하나의 객체로 구성하기 위해서 생성자를 호출한다
				// 배열의 10칸 중에서 빈칸을 하나 찾아서 거기에 객체를 생성하고 값을 넣어준다
				// 다음칸에도 똑같은 값을 넣으면 안되니까 break를 수행한다
				for (int i = 0; i < arr.length; i++) {  // 배열의 처음부터 끝까지 순회하면서
					if (arr[i] == null) { 				// 빈칸을 찾았다면
						arr[i] = book;					// 값이 준비된 객체
						break; 							// 다음칸에 또 값을 넣으면 안되니까 break (반복중단)
					}
				}
				break;// 추가하고 나서 break가 없으면 case 0으로 넘어가니까 switch의 break
			
			case 3:
				// 배열 내부의 도서 중에서 이름이 일치하는 객체를 찾아서 제거한다
				System.out.println("검색어를 입력하세요: ");
				name = sc.nextLine();
				
				row = deleteBook(name,arr);
				System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
				break;
			
			case 0:
				System.out.println("프로그램 종료");
				break;
			}
		}
		//마무리 종료
		sc.close();
	} // end of main(0
}	// end of class
