package book5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

// [데이터 저장소(배열 -> 리스트 -> 파일 -> DB)]를 직접 참조하거나, 연결할 수 있음

// 프로그램의 주요 기능(목록/추가/삭제 등)을 모아둔 클래스

public class Handler {
	// 배열에서 리스트로 전환(배열의 자료형은 리스트의 제네릭타입이된다)
	private ArrayList<Book> list = new ArrayList<>();

	// 파일 저장 및 불러오기 함수
	private File f = new File("bookList.csv");

	public Handler() {
		if (f.exists() == false) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("\t파일을 생성하는데에 문제가 발생했습니다:" + e);
				e.printStackTrace();
			}
		}
	}

	// 저장
	public void save() {
		try {
			// 프로그램의 데이터를 파일로 내보내는 스트림(데이터 이동 통로)
			FileOutputStream fos = new FileOutputStream(f);
			// 스트림으로 문자열 형식 데이터를 전달하는 기능이 추가된 클래스
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			for (Book ob : list) {
				String name = ob.getName();
				String author = ob.getAuthor();
				String publisher = ob.getPublisher();
				int price = ob.getPrice();

				// 아래 서식은 띄어쓰기 없이 콤마로만 구분하기
				String data = String.format("%s,%s,%s,%s", name, author, publisher, price);
				osw.write(data);
				osw.write('\n');
			}
			osw.flush();
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		try {
			Scanner sc = new Scanner(f);
			String data = "";
			while (sc.hasNextLine()) {
				data = sc.nextLine();
				if (data.length() != 0) {
					String[] arr = data.split(",");
					Book b = new Book();
					b.setName(arr[0]);
					b.setAuthor(arr[1]);
					b.setPublisher(arr[2]);
					b.setPrice(Integer.parseInt(arr[3]));
					list.add(b);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}// end of load

	public void showList() {
		// 3) 람다식 + 컬렉션 forEach()
		list.forEach(ob -> System.out.println(ob));

	}

	// 도서 추가
	public int insertBook(Book ob) {
		int row = 0;

		boolean flag = list.add(ob); // 추가 성공하면 true가 반환된다
		row = flag ? 1 : 0; // true이면 row가 1, 아니면 row가 0
		return row;
	}

	// 도서 이름을 전달 받아서, 배열 안에서 일치하는 객체를 찾아서 삭제하는 함수
	public int deleteBook(String name) {
		int row = 0;

		// 조건에 맞는 요소를 삭제하는 리스트의 함수(반환값은 boolean 타입)
		boolean flag = list.removeIf(ob -> ob.getName().equals(name));
		row = flag ? 1 : 0;
		return row;
	}

}