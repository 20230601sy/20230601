package N02_overriding;

public class S02_Cartoon extends S02_Book {
	int pages;

	public S02_Cartoon(String title, String author, int page) {
		super(title, author);
		this.pages = pages;
	}

	@Override
	public void showInfo() {
		System.out.println("Cartoon showInfo");
		super.showInfo();
		System.out.println("페이지수 : " + pages);
	}

	@Override
	public String toString() {
		return "Cartoon [title=" + title + ", author=" + author + ", pages=" + pages + "]";
	}

	@Override
	public void showPrice() {
		System.out.println("책이름 : " + title + "\n가격 : " + (int)(price*0.8));
	}
	
}
