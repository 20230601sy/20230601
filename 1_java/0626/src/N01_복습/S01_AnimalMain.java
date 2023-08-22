/*
 * 동물들을 저장할 수 있는 배열을 만들어서 원하는 만큼 배열에 동물들을 저장(강아지, 고양이)
 * 배열에 저장된 동물들의 이름과 동물별 소리가 출현되도록 구현
 */
package N01_복습;

import java.util.Scanner;

public class S01_AnimalMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("동물배열 크기 : ");
		int size = sc.nextInt();
		S01_Animal[] arr = new S01_Animal[size];
		
		for(int i=0; i<arr.length; i++) {
			if(Math.random()<0.5)
				arr[i] = new S01_Dog("멍멍이"+(i+1),"견종"+(i+1));
			else
				arr[i] = new S01_Cat("냐옹이"+(i+1),"색상"+(i+1));
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");//.getName() + " : "); // 여기서 견종이나 색상을 출력할 수 있을까? 직접적인 호출은 안되지만 오버라이딩 메서드를 이용하면 가능하다는 거지.
			arr[i].makeSound();
		}
	}
}
