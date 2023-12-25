package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Phonebook{
	private String name;
	private String pnum;
	
	public Phonebook(String name, String punm) {	// 생성자 (저장, 우클릭 s,o)
		this.name = name;
		this.pnum = punm;
	}
	
	@Override
	public String toString() {	// 메서드(오바라이딩, 슈퍼클래스의 메서드를 상속받아서 재정의한다
		return String.format("%s : %s", name, pnum);
	}
	
	public String getName() {	// 메서드(getter/setter)(저장, 우클릭 s,r ,alt +a,r)
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	
}

public class Ex07 {
	public static void main(String[] args) throws Exception {
		File f = new File("7.txt");
		ArrayList<Phonebook> list = new ArrayList<>();
		
		if(f.exists() == false) {	// 만약 파일이 없으면 새로 만든다
			f.createNewFile();
		}
		else {						// 파일이 있으면 파일을 읽어서 객체를 읽어서 리스트에 담는다
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String[] arr = sc.nextLine().split(" : ");
				Phonebook ob = new Phonebook(arr[0], arr[1]);
				list.add(ob);
			}
			sc.close();
		}
		
		System.out.println("=== 출력 ===");
		list.forEach(ob -> System.out.println(ob));
		System.out.println("=== 출력 끝 ===");
		
		Scanner sc = new Scanner(System.in);
		String name, pnum;
		System.out.print("새로 추가할 사람의 이름 :");
		name = sc.nextLine();
		System.out.print("새로 추가할 사람의 전화번호 :");
		pnum = sc.nextLine();
		
		Phonebook ob = new Phonebook(name, pnum);
		list.add(ob);
		
		FileOutputStream fos = new FileOutputStream(f);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		for(Phonebook pb : list) {
			osw.append(pb.toString() + "\n");
		}
		osw.flush();
		osw.close();
		fos.close();
		sc.close();
		System.out.println("저장 끝, 프로그램 종료");
		

	}
}
