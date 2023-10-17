package variable;

public class Quiz02 {
     public static void main(String[] args) {
		 // 자신의 이름을 문자열 변수에 저장하세요 (문자열은 primitive가 없습니다. String)
    	 String name = "정진석";
    			 
    	 // 자신의 나이를 정수형 변수에 저장하세요
    	 int age = 31;
    	 
    	 // 새로운 실수형 변수에 0을 대입하세요
    	 double db = 0;//우변의 자료형이 명시되지 않는 리터럴이지만, 리터럴 정수의 기본자료형은 int이다(literal이란 소스코드의 고정된 값을 나타내는 표기법)
    	 // 방금 만든 실수형 변수에 3.14를 대입하세요
    	 db = 3.14;
    	 // 지금까지 만든 3개 변수에 담긴 값을 각각 한줄씩 화면에 출력하세요
    	 // (primitive 를 이용해서 한번, Wrapper class 를 이용해서 한번 코드를 실행하세요)
    	 
    	 //primitive
    	 System.out.println("이름 : " + name);
    	 System.out.println("나이 : " + age);
    	 System.out.println("실수형 변수 : " + db);
    	 
    	 //Wrapper class
    	 Integer age2 = 31;
       	 Double  db2 = db; 	 //type mismatch: cannot convert from int to Double,(.0),(double)0,Double.valueOf(0)
    	 db2 = 3.14;         //실수의 대표자료형은 double 이므로, 리터럴 값도 double 타입을 가지게 된다
    	 
    	 System.out.println("이름 : " + name);
    	 System.out.println("나이 : " + age2);
    	 System.out.println("실수형 변수 : " + db2);
    	 
    	 
    }
}
