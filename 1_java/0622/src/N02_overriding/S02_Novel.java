package N02_overriding;

public class S02_Novel extends S02_Book {
	String genre;

	public S02_Novel(String title, String author, String genre) {
		super(title, author);
		this.genre = genre;
	}

	@Override
	public void showInfo() {
		System.out.println("Novel showInfo");
		super.showInfo();
		System.out.println("장르 : " + genre);
	}

	@Override
	public String toString() {
		return "Novel [title=" + title + ", author=" + author + ", genre=" + genre + "]";
	}

	@Override
	public void showPrice() {
		System.out.println("책이름 : " + title + "\n가격 : " + (int)(price*0.9));
	}
	
}
