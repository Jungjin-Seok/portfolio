package accessModifier;

public class Ex02 {
	public static void main(String[] args) {
		
		Human ob1 = new Human();
//		ob1.name = "이지은";	안됨
		ob1.setName("이지은");
		
//		ob1.age = 30; 안됨
		ob1.setAge(30);
		
//		System.out.println("이름 : " + ob1.name); 안됨
		System.out.println("이름 : " + ob1.getName());

//		System.out.println("나이 : " + ob1.age);	안됨
		System.out.println("나이 : " + ob1.getAge());
		
		// 클래스 작성자가 메서드를 작성하지 않으면
		// 접근할 수 없으며, 클래스 작성자의 의도대로 움직이게 할 수 있다
		
		
			
	}
}
