package abstraction;

abstract class Loop {
	abstract void loop();
	void info() {
		System.out.println("반복을 수행하는 클래스 입니다");
	}
}

class NumberLoop extends Loop {

	@Override
	void loop() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + " ");
		}
		System.out.println();
	}
	
}



public class Ex08 {
	public static void main(String[] args) {
		
	}
}
