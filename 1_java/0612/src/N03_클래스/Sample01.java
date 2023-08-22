package N03_클래스;
public class Sample01 {
	public static void main(String[] args) {
		Animal cat = new Animal();
		/*
		 * Animal : 클래스
		 * cat : 객체
		 * cat객체는 Animal 클래스의 인스턴스
		 * cat은 객체다
		 * Animal 클래싀의 객체는 cat이다라는 표현보다 인스턴스라는 표현을 씀
		 * cat만 만들 수 있는 것이 아니므로...
		 * 근데 인스턴스라는 표현을 잘 쓰지도 않고 그냥 그러려니 하고 넘어가라심 헤헷
		 */
		cat.name = "야옹이"; // xx.yy 는 xx에 소속된 yy를 의미
		System.out.println("cat name : " + cat.name);
		// Animal class만 멤버변수를 추가하게 수정해서 변수를 일괄적으로 만들 수 있음
		cat.age = 5;
		System.out.println("cat age : " + cat.age);
		
		Animal dog = new Animal();
		System.out.println("dog name : " + dog.name); // (cat.)name 값 설정했다고, dog.name 초기화 안 하면 안 나옴
		dog.name = "멍멍이";
		System.out.println("dog name : " + dog.name);
		cat.age = 3;
		System.out.println("dog age : " + dog.age);
		
		cat.showInfo(); // ()괄호가 없으면 변수로 인식함
		dog.showInfo();
		
		// 나중에 되면 main에는 code가 별로 없고 다 각각의 class에 있음
		
	}
}
