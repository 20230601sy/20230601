// 5개의 점수를 입력받아서 출력
package N02_배열;

import java.util.Arrays;
import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];
		for(int i=0; i<5; i++) {
			System.out.print((i+1) + "번째 점수 입력 : ");
			score[i] = sc.nextInt();
		}
		System.out.println("====결과 확인1====");
		for(int i=0; i<5; i++)
			System.out.print(score[i] + " ");
		System.out.println();
		System.out.println("====결과 확인2====");
		System.out.println("score.length : " + score.length);
		for(int i=0; i<score.length; i++) // 배열 크기 알려주는 명령어를 사용하면, 귀찮게 배열 크기를 항상 기억하고 있을 필요가 없어지고 나중에 배열크기가 변경이 필요할 때도 코드 수정이나 유지보수에 용이
			System.out.print(score[i] + " ");
		System.out.println();
		System.out.println("====결과 확인3====");
		// 향상된 for문 (8버전부터 생겼으면 난 본적이 없겠군ㅋㅋㅋ)
		// a는 임시로 보관해서 사용할 변수, 아무 거나 상관없는데, 자료형은 배열의 자료형과 동일해야 함
		// 반복 횟수같은 건 신경 안 써도 알아서 해준다는 의미!!! 이거 좋네, python에서 in이랑 비슷한 듯
		// 향상된 for문은 편해 보이죠? 그래서 배열이나 차후에 사용할 collection 같은 곳에서 쓸 수 있음
		// a는 지금 임시로 써놨는데 보통은 배열명을 scores(s 붙이고), for문 임시변수를 score를 붙이기도 함(당연히 중복 이름은 쓸 수 없음)
		// 그런데! 향상된 for문은 변수를 따로 저장하지 않는 이상 index i를 사용하기 어려움! 순서가 중요할 때는 .length 사용하는 게 나을 듯
		for(int a : score)
			System.out.print(a + " ");
		System.out.println();
		System.out.println("====결과 확인4====");
		// 배열에 저장된 값 단순 출력, 작업은 안 됨, Arrays.toString 쓰면 반복문은 안 써도 됨, A랑 S 대소문자이니까 신경쓸 것!
		// 지금 단계에서 용어를 써서 설명하기는 어려우니 현시점에서는 그냥 자바 명령어라고 생각하라심
		// 출력이 된 거는 정확하게는 각각 따로 출력한 게 아니고, 하나의 문자열임 eg. "[3, 6, 5, 7, 9]"
		// 실제로 많이 쓸일은 없다심
		System.out.println(Arrays.toString(score));
	}
}