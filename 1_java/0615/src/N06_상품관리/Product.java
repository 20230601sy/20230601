package N06_상품관리;

public class Product {
	String productId; // 나중에 DB할 때 할 건데, 바지 12,000원과 바지 8,000원을 구분하기 위해서 ItemNo 같은 거 있으면 편함
	String name;
	int price;
	int stock;
	
	public Product(String productId, String name, int price, int stock) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public String getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public void sellStock(int stock) {
		if(this.stock < stock) {
			System.out.println("*상품 재고 부족, 판매 불가");
			return;
		}
		this.stock = this.stock - stock;
		System.out.println("→ " + this.name + " " + stock + "개 판매, 판매 금액 : " + this.price*stock + "원, 남은 재고 : " + this.stock + "개");
	}
}
