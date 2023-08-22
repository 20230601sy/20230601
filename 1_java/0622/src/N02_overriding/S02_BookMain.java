package N02_overriding;

public class S02_BookMain {

	public static void main(String[] args) {
		S02_Book b = new S02_Book("Java의 정석", "남궁성");
		S02_Novel n = new S02_Novel("홍길동전", "허균", "고전소설");
		S02_Cartoon c = new S02_Cartoon("원피스", "오다 에이치로", 350);
		System.out.println("구분선 0 ========================================");
		System.out.println(b.title + "	" + b.author);
		System.out.println(n.title + "		" + n.author + "		" + n.genre);
		System.out.println(c.title + "		" + c.author + "	" + c.pages);
		System.out.println("구분선 1 ========================================");
		b.showInfo();
		n.showInfo();
		c.showInfo();
		System.out.println("구분선 2 ========================================");
		System.out.println(b.toString());
		System.out.println(n.toString());
		System.out.println(c.toString());
		System.out.println("구분선 3 ========================================");
		b.showPrice();
		n.showPrice();
		c.showPrice(); // 그러면 c에서 Book의 showPrice는 아예 못 호출하게 되는 ... ???
		System.out.println("구분선 4 ========================================");
		
	}

}
