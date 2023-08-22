package N03_추상화;

public abstract class S01_Shape {
	public abstract double calcArea(); // 도형 넓이 계산해주는 메서드, 상속받은 메서드에서 무조건 오버라이딩 해야 됨
	public void hello() { // 오버라이딩 안 해도 됨
		System.out.println("hello");
	}
}
