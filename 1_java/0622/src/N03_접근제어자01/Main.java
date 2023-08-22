package N03_접근제어자01;

public class Main {

	public static void main(String[] args) {
		Animal a = new Animal();
//		System.out.println(a.name); // name을 private으로 설정했기 때문에 에러!
		System.out.println(a.age);
		System.out.println(a.getName()); // 캡슐화의 기본 형태, 지금 뭐 캡슐화까지는 됐고, private이 어떻게 막아버렸는지만 기억하라심
//		a.name = "야옹이"; // 이것도 못해!
		a.setName("야옹이"); // setName은 public으로 설정되어 있기 때문에 접근 가능
		/*
		 * 게터와 세터는 왜 쓸까?
		 * 직빵으로 a.name
		 * 보안! 정보 은닉 목적
		 * 캡슐화 - 정보 은닉
		 * 알약에서 껍데기는 약이 아니잖아요 ㄷㄷ 껍데기가 메서드가 된거고 실제 내용물, 이게 변수명이 뭐고 등등은 모른다는 거
		 * 별 특별한 이유 없으면 클래스 변수는 다 private으로 작업한다. 
		 */
	}

}
