package N06_상품관리;

public class Inventory {
	Product[] products;
	int numProducts; // 상품 수, 배열을 10칸짜리를 만들었다고 해서 10개가 판매중인 건 아니기 때문에 만드는 변수
	public Inventory(int maxSize) {
		numProducts = 0;
		products = new Product[maxSize];
	}
	public boolean addPossible() {
		return (numProducts < products.length);
	}
	public void addProduct(Product p) {
		products[numProducts] = p;
		numProducts++;
		System.out.println("→ 상품 추가 완료");
	}
	public int findProductIndex(String productId) {
		for(int i=0; i<numProducts; i++) {
			if(productId.equalsIgnoreCase(products[i].getProductId())) // String도 주소값을 담고 있기 때문에 equals 사용해야 함!
				return i;
		}
		return -1;
	}
	public void sellProduct(String productId, int stock) {
		int index = findProductIndex(productId);
		if(index == -1) {
			System.out.println("*등록된 상품이 아닙니다.");
			return;
		}
		Product p = products[index];
//		if(p.stock<stock) {
//			System.out.println("*상품 재고 부족, 판매 불가");
//			return;
//		}
//		p.stock = p.stock - stock; // 이거 이렇게는 안 하고 별도로 작업이 되도록 하게 할 거라고 하심... 
//		System.out.println("→ " + p.getName() + " " + stock + "개 판매 완료, " + p.getPrice()*stock + "원");
		// 왜냐하면 이거는 인벤토리에서 구현시킬 내용이 아니라 프로덕트에서 구현할 내용이기 때문임
		// 나중에 실무하면 팀장급들이 만든 가이드라인이 있음, 틀이 갖춰져 있기 때문에 고민할 필요가 없어지는데...아무튼...
		p.sellStock(stock);
	}
	public void getAllProducts() {
		if(numProducts==0) {
			System.out.println("*현재 등록된 상품이 없습니다.");
			return;
		}
		System.out.println("[3]전체조회===============================");
		for(int i=0; i<numProducts; i++) {
			Product p = products[i];
			// 나중에는 멤버변수를 직접 호출할 수 없는 경우가 생기는데 지금은 설명하기 어렵다심...지금은 그냥 써도 되는 거고... get으로 써도 된다고 하심
			System.out.println("[" + p.productId + "] 상품명 : " + p.name + ", 가격 : " + p.price + "원, 재고 : " + p.stock + "개");
		}
		System.out.println("========================================");
	}
}
