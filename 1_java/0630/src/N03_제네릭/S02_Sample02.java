package N03_제네릭;

import java.util.ArrayList;
import java.util.List;

class Product{} // class Product<T>{}
class Tv extends Product{}
class Audio extends Product{}

public class S02_Sample02 {

	public static void main(String[] args) {
		ArrayList<Product> list1 = new ArrayList<>(); // Product가 생략됨!, 생략 권장, new ArrayList<Product>();
//		ArrayList<Product> list2 = new ArrayList<Tv>(); // 다형성 적용 안됨!!! 무조건 선언부와 생성부가 동일해야 함!!!
		List<Product> list3 = new ArrayList<>(); // 이건 제네릭스 다형성은 아니고 List와 ArrayList에 대한 다형성이 적용된 거임, 책에 헷갈릴 수도 있게 적혀있다고 설명하심
		list1.add(new Product());
		list1.add(new Tv()); // 이건 다형성 적용됨, 위에서 안되는 건 처음 선언부할 때만 신경쓰라는 의미임!!!
	}

}
