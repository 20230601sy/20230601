package N05_내부클래스;

public class S03_ParentMain {

	public static void main(String[] args) {
		S03_Parent p = new S03_Parent();
		S03_Parent anonymous = new S03_Parent() {
			/*
			 * 익명클래스 영역
			 * 메소드 오버라이딩도 가능하다!
			 */
			public void work() {
				System.out.println("익명 노동 중");
			}

			@Override
			public void wake() {
				System.out.println("익명 10시 기상");
				work();
			}
		};
		
		anonymous.wake();
//		anonymous.work(); // Parent 형변환되었기 때문에, 내부 메서드는 독립적으로 호출은 못함!
	}

}
