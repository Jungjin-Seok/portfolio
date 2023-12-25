package book4;

// 접근제한자 + getter/setter


public class Book {

	// 단일 객체 자료형을 정의해야 한다
	private String name;	// 클래스 내부에서는 자유롭게 접그닝 가능하다
	private String author;
	private int price;
	private String publisher;
	
	// 출력 서식을 toString으로 오버라이딩
	@Override
	public String toString() {
		String data = String.format("%s (%s,%s) : %,d원\n",
		//this.name,
		name,
		author,
		publisher,
		price);
		return data;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
