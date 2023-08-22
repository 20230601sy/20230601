package N06_상품관리;

import java.util.Scanner;

public class PMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxSize = 10;
		Inventory inven = new Inventory(maxSize); // 바꾸고 싶으면 scanner 쓰면 됑, 지금은 넘어갈 거라심
		String productId;
		String name;
		int price;
		int stock;
		
		while(true) {
			System.out.print("[1]상품추가 [2]상품판매 [3]전체조회 [0]종료 : ");
			int choice = sc.nextInt();
			if(choice == 0)
				break;
			switch(choice) {
				case 1: // 판매할 상품정보 추가
					if(!inven.addPossible()) {
						System.out.println("상품을 더 이상 추가 등록할 수 없네요!");
						break;
					}
					System.out.print("추가 상품 아이디 : ");
					productId = sc.next();
					System.out.print("추가 상품명 : ");
					name = sc.next();
					System.out.print("추가 상품 가격 : ");
					price = sc.nextInt();
					System.out.print("추가 상품 재고 : ");
					stock = sc.nextInt();
					Product p = new Product(productId, name, price, stock);
					inven.addProduct(p);
					break;
				case 2:
					System.out.print("판매 상품 아이디 : ");
					productId = sc.next();
					System.out.print("판매 상품 수량 : ");
					stock = sc.nextInt();
//					Product p = new Product(productId, "", 0, stock);
//					inven.sellProduct(p);
					inven.sellProduct(productId, stock);
					
					break;
				case 3:
					inven.getAllProducts();
					break;
			}
		}
	}

}
