package N02_overriding;

import java.util.Scanner;

public class S03_AnimalMain {

	public static void main(String[] args) {
		S03_Dog d = new S03_Dog("멍멍이", "잡스");
		S03_Cat c = new S03_Cat("냐옹이", "고등어");
		d.showBreed();
		c.showColor();
		
		Scanner sc = new Scanner(System.in);
		System.out.print(d.name + " 나이 입력 : ");
		d.setAge(sc.nextInt());
		System.out.print(c.name + " 나이 입력 : ");
		c.setAge(sc.nextInt());
		System.out.println("Dog : " + d.age);
		System.out.println("Cat : " + c.age);
		
		System.out.println(d.name + " 나이 " + d.age + "는 사람 나이로 "+ d.getAge() + "입니다.");
		System.out.println(c.name + " 나이 " + c.age + "는 사람 나이로 "+ c.getAge() + "입니다.");
	}

}
