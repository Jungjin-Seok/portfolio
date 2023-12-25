package book3;

// [데이터 저장소(배열 -> 리스트 -> 파일 -> DB)]를 직접 참조하거나, 연결할 수 있음

// 프로그램의 주요 기능(목록/추가/삭제 등)을 모아둔 클래스

public class Handler {

	private Book[] arr = new Book[10];

	// 출력
	public void showList() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				arr[i] = new Book();
				arr[i].getName();
				arr[i].getAuthor();
				arr[i].getPublisher();
				arr[i].getPrice();
			}
		}
	}

	// 도서 추가
	public int insertBook(Book ob) {
		int row = 0;
		for (int i = 0; i < arr.length; i++) { // 배열의 처음부터 끝까지 순회하면서
			if (arr[i] == null) { // 빈칸을 찾았다면
				arr[i] = ob;
				row = 1; // 값이 준비된 객체
				break;	 // 다음칸에 또 값을 넣으면 안되니까 break (반복중단)
			}
		}
		return row;
	}

	// 도서 이름을 전달 받아서, 배열 안에서 일치하는 객체를 찾아서 삭제하는 함수
	public int deleteBook(String name) {
		int row = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].getName().equals(name)) {
				arr[i] = null; // 참조변수가 객체를 참조하지 않도록 한다
								// 모두에게서 잊혀진 참조변수는 소멸한다
				row = 1; // 삭제했다는 결과를 반환하기 위해 row값을 1로 설정한다
				break; // 하나 지웠으면 중단한다.
			}
		}
		return row;
	}

}