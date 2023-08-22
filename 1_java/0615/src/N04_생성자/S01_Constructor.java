package N04_생성자;

public class S01_Constructor {
	String name;
	int age;
	public S01_Constructor() { // 이런 게 없으면 Java가 알아서 만들어줌
		System.out.println("객체 생성");
	}
	public S01_Constructor(String name) { // 생성자의 매개변수가 있는 형태
		this.name = name;
		this.age = 18; // age = 18; 해도 되는데 명시를 해주는 편을 선호하는 듯한 분위기로 말씀하심
	}
	/*
	 * 매개변수가 있는 생성자를 만들 경우 기본 생성자가 사라지기 때문에 Java가 알아서 만들어주지 않음
	 * 필요할 경우 기본 생성자를 생성하는 코드를 작성해야 함
	 * 그렇다는 말은 생성자도 오버로딩이 됨!
	 */
	public S01_Constructor(String name, int age) { // 생성자의 매개변수가 있는 형태
		this.name = name;
		this.age = age; 
	}
	/*
	 * getter setter처럼 생성자도 자동으로 생성 가능함
	 * Generate Constructor using Fields
	 * 추가 설정이 필요한 경우는 직접 수정해야 함 eg. 출력, 지정, 계산 등
	 * 생성자는 사용하는 건 메서드랑 동일함
	 */
}
