package N01_캡슐화;

import java.util.Scanner;

public class S01_Person {
	String name;
	private int age; // 변수는 어지간하면 private으로 설정해둠
	Scanner sc = new Scanner(System.in);
	
	public void setAge() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		setAge(age);
	}
	public void setAge(int age) {
		if(age>=1 && age<=100)
			this.age = age;
		else
			System.out.println("잘못 입력하셨습니다.");
		
//		System.out.println(this.age); 기능별로 나눠서 하는 것을 권장, 하나의 메서드에는 하나의 기능만 담자!
	}
	public int getAge() {
		return age;
	}
	
//	public void getSum(Person p1, Person p2, Person p3) {
//		System.out.println(p1.age+p2.age+p3.age);
//	}
}
