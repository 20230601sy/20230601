package N03_제네릭;

import java.util.ArrayList;
import java.util.List;

class Shape{}
class Circle extends Shape{}
class Rectangle{}

class Box<T>{
	T shape;  // T 도형 담는 참조 변수, 무슨 도형일지 정해지지 않음, 때에 따라 다르게 
}
class Box2<T extends Shape>{ // Shape 자기 자신 포함한 상속 받은 아이들만 담을 수 있음!
	T shape;
}
public class S03_Sample03 {

	public static void main(String[] args) {
		Box<Shape> box1 = new Box<>();
		Box<Circle> box2 = new Box<>();
		Box<Rectangle> box3 = new Box<>();
		Box<String> box4 = new Box<>(); // 그냥 T로 하면 따지면 String도 된다는 거~
		
		Box2<Shape> box5 = new Box2<>();
		Box2<Circle> box6 = new Box2<>(); // extends 사용 하면 가능!
//		Box2<Rectangle> box7 = new Box2<>(); // 불가!
//		Box2<String> box8 = new Box2<>(); // 불가!
		
		/*		
		 * 469p 와일드 카드 ? 모든 문자를 다 받을 수 있는 만능형 문자
		 * 자바에서만 쓰는 용어는 아님
		 * 윈도우에서도 사용 가능 *.jpg
		 * 대체적으로 기호는 * 아님 ? 를 씀
		 * T 도 되는 거 아님? 왜 와일드 카드가 나왔겠음 
		 */
		List<?> list = new ArrayList<>();
		list.add(null);
//		list.add("abc"); // 애초에 list ? 는 null만 넣을 수 있음
//		? super 이건 다음시간~~~
	}

}
