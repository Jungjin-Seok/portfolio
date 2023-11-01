package book;

// 단일 데이터를 필드와 getter/setter 로 구성

public class Book {
	
		private String name;
		private String genre;
		private int price;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public int getprice() {
			return price;
		}
		public void setprice(int price) {
			this.price = price;
		}
	
}
