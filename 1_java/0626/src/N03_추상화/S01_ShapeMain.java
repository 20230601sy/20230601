package N03_추상화;

public class S01_ShapeMain {

	public static void main(String[] args) {
		
//		Shape s = new Shape(); // 추상클래스는 인스턴스 생성 불가
		S01_Rectangle r = new S01_Rectangle(5, 10);
		S01_Shape s = new S01_Rectangle(8, 9); // 형변환은 됨~
		r.hello();
		s.hello();
		System.out.println("넓이 : " + r.calcArea());
		System.out.println("넓이2 : " + s.calcArea()); // 오버라이딩 메서드 호출은 문제없이 잘됨
		
	}

}
