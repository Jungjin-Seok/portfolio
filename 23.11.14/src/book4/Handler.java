package book4;

import java.util.ArrayList;

// [데이터 저장소(배열 -> 리스트 -> 파일 -> DB)]를 직접 참조하거나, 연결할 수 있음

// 프로그램의 주요 기능(목록/추가/삭제 등)을 모아둔 클래스

public class Handler {

//	private Book[] arr = new Book[10]; //여러 Book 객체를 저장하기 위한 배열
	
	// 배열에서 리스트로 전환(배열의 자료형은 리스트의 제네릭타입이된다)
	private ArrayList<Book> list = new ArrayList<>();

//=============================================
/*
		array 와 list의 비교
 		
 		[array]				[list]
 		
 		arr.length			list.size()
 		arr[i] 				list.get(i)
 		arr[i] = ob			list.add(ob)
 		arr[i] = null		list.remove(i)
 							list.remove(ob)
 */
//===============================================	
	
	// 배열을 전달받아서, 배열 내부의 각 객체를 서식에 맞게 출력하는 함수 (case 1)
	// 4개 중 택1 모두 다 알고 있으면 좋다
	public void showList() {
//		// 1) index를 사용하는 for문
//		for (int i = 0; i < list.size(); i++) {
//			Book ob = list.get(i);
//			System.out.println(ob);
//			}
//		// 2) 향상된 for문 (index를 사용하지 않음)
//		for(Book ob : list) {
//			System.out.println(ob);
//		}
		
		// 3) 람다식 + 컬렉션 forEach()
		list.forEach(ob -> System.out.println(ob));
		
//		// 4) 메서드 참조
//		list.forEach(System.out::println);
	}
	

	// 도서 추가
	public int insertBook(Book ob) {
		int row = 0;
//		for (int i = 0; i < arr.length; i++) { // 배열의 처음부터 끝까지 순회하면서
//			if (arr[i] == null) { // 빈칸을 찾았다면
//				arr[i] = ob;
//				row = 1; // 값이 준비된 객체
//				break;	 // 다음칸에 또 값을 넣으면 안되니까 break (반복중단)
//			}
//		}
		boolean flag =  list.add(ob);	// 추가 성공하면 true가 반환된다
		row = flag ? 1 : 0;				// true이면 row가 1, 아니면 row가 0
		return row;	
	}

	// 도서 이름을 전달 받아서, 배열 안에서 일치하는 객체를 찾아서 삭제하는 함수
	public int deleteBook(String name) {
		int row = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] != null && arr[i].getName().equals(name)) {
//				arr[i] = null; // 참조변수가 객체를 참조하지 않도록 한다
//								// 모두에게서 잊혀진 참조변수는 소멸한다
//				row = 1; // 삭제했다는 결과를 반환하기 위해 row값을 1로 설정한다
//				break; // 하나 지웠으면 중단한다.
//			}
//		}
		// 조건에 맞는 요소를 삭제하는 리스트의 함수(반환값은 boolean 타입)
		boolean flag = list.removeIf(ob -> ob.getName().equals(name));
		row = flag ? 1 : 0;
		return row;
	}

}