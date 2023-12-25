package functionalInterface;

interface Test{//함수형 인터페이스
	void method(String s);//인터페이스 중에서 추상메서드가 오직하나만 있는 형식
}

class Repository {
	String[] arr = new String[] {			
	"이지은","홍진호","짱구","단비","김태리"
	};
	
	public void forEach(Test lambda) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
				lambda.method(arr[i]);
			}
		}
	}
}

public class Ex01 {
	public static void main(String[] args) {
		Repository repo = new Repository();
	
		repo.forEach(str -> System.out.println(str));
		System.out.println();
	
		repo.forEach(str -> System.out.println(str.length()));
		System.out.println();
		
		Test lambda = (str) -> {
			String odd = "홀수";
			if(str.length() % 2 == 0) {
				odd = "짝수";
			}
			System.out.println(odd);
		};
		repo.forEach(lambda);
	}
	
}
