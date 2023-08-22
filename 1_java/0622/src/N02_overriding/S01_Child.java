package N02_overriding;

public class S01_Child extends S01_Parent {

	@Override
	public void showInfo(int age) {
		System.out.println("자식 나이 : " + age);
	}
	
}
