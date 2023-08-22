package N02_열거타입;

//public enum S02_UserRole {
//	ADMIN,
//	GUEST
//}

public enum S02_UserRole {
	ADMIN("관리자"),
	GUEST("게스트"); 
	/*
	 * 이름 같은 초기값을 지정해줄 수 있음
	 * 방법은 세미콜론으로 끝내고 생성자가 필요함
	 * new S02_UserRole(name) 처럼 같은 느낌이라고 생각하면 됨!
	 * 당연하지만 매개변수는 name 하나만 있어야 하는 거 아니고 클래스 만들듯이 여러 개 있어도 됨!
	 */
	
	private String name;
	
	S02_UserRole(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}