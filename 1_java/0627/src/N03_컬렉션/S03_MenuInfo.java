package N03_컬렉션;

public class S03_MenuInfo {
	
	String name;
	int price;
	boolean isTax;
	
	public S03_MenuInfo(String name, int price, boolean isTax) {
		this.name = name;
		this.price = price;
		this.isTax = isTax;
	}

	@Override
	public String toString() {
//		return "S03_MenuInfo [name=" + name + ", price=" + price + ", isTax=" + isTax + "]";
		return "\t[name=" + name + ",	price=" + price + ",	isTax=" + isTax + ",	totalPrice="+ totalPrice()+"]	";
	}
	public int totalPrice() {
		return (isTax)? (int) (price * 1.1) : price; // 나중에 if를 못쓰는 구간이 생긴다고 하심. react의 특정영역에서는 if를 못써서 삼항연산 쓸 수밖에 없음...
	}

}
