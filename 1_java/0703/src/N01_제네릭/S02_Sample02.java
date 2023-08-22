// 470p 교재 예제
package N01_제네릭;

class Fruit{ }
class Apple extends Fruit { }
class Juice { }
class Juicer {
	static void makeJuice(FruitBox<? extends Fruit> box) { } // class를 만들 때 저렇게 만들어놨으면 매개변수 제네릭에는 extends Fruit 안 써도 되긴 함
}

class Box<T> { }
class FruitBox<T extends Fruit> extends Box<T> { }
public class S02_Sample02 {

	public static void main(String[] args) {
		Box box1 = new Box();
		Box<String> box2 = new Box<String>();
		Box<Fruit> box3 = new Box<Fruit>();
		
		FruitBox<Fruit> box4 = new FruitBox<>();
		FruitBox<Apple> box5 = new FruitBox<>();
		Juicer.makeJuice(box4);
		Juicer.makeJuice(box5);
	}

}
