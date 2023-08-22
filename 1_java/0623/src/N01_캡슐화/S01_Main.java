package N01_캡슐화;

import java.util.Scanner;

public class S01_Main {

	public static void main(String[] args) {
		S01_Person p = new S01_Person();
		p.name = "홍길동";
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
//		if(age>=1 && age<=100)
//			p.age = age;
//		else
//			System.out.println("잘못 입력하셨습니다.");
		
//		p.age = 200; 	// 이런 걸 입력 받을 때와 같이 제한을 적용할 수 없음...setAge(age)
		// 접근제한자 private를 통해서 직접 입력할 수 없게 제한시킴!
		p.setAge(age); 	// 어지간하면 입력값은 메인에서 받고 남겨둠, 좋은 습관!
//		p.setAge(); 	// 메인에서 받는 것을 권장
		
		S01_Person p1 = new S01_Person();
		S01_Person p2 = new S01_Person();
		S01_Person p3 = new S01_Person();
		p1.setAge(20);
		p2.setAge(30);
		p3.setAge(50);
		int sum = p1.getAge() + p2.getAge() + p3.getAge();
//		p1.getSum(p1, p2, p3); 뭐 굳이 하자면 이렇게 가능하긴 함. 그런데 Person에 구현하는 걸 하는 사람은 Main 유저가 아니잖아.
		
	}

}
