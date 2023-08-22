package N02_overriding;

public class S02_Book {
	String title;
	String author;
	int price;
	
	public S02_Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.price = 10000;
	}
	public void showInfo() {
		System.out.println("책이름 : " + title + "\n저자 : " + author);
	}
	// showInfo() 대신에 멤버변수 출력 메서드 자동 생성!
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}
	public void showPrice() {
		System.out.println("책이름 : " + title + "\n가격 : " + price);
	}
}
