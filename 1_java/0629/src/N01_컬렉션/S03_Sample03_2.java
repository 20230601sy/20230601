/*
 * 숫자를 계속 입력 받음 (종료 : 0)
 * 입력 받은 숫자들을 홀수와 짝수 나눠서 보관
 * 종료가 되면 입력한 숫자들의 
 * 홀수들 목록, 홀수들의 합계, 평균
 * 짝수들 목록, 짝수들의 합계, 평균
 * 메서드로 구현
 */

package N01_컬렉션;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class S03_Sample03_2 {

	public static void main(String[] args) {
		ArrayList<Integer> numList = scanNum();
		ArrayList<Integer> oddList = getEvenOrOddList(numList, 1);
		ArrayList<Integer> evenList = getEvenOrOddList(numList, 0);
		printInfo(oddList, "홀수들");
		printInfo(evenList, "짝수들");
	}
	public static ArrayList<Integer> scanNum(){ // 제네릭 활용하면 상황에 따라 입력받는 데이터 타입을 다르게 하는 거도 가능하다심
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int num;
		do {
			System.out.print("숫자 입력(종료:0) : ");
			num = sc.nextInt();
			if(num !=0)
				list.add(num);
		} while(num != 0);
		return list;
	}
	public static ArrayList<Integer> getEvenOrOddList(ArrayList<Integer> numList, int evenOrOdd){
		ArrayList<Integer> list = new ArrayList<>();
		for(int num : numList)
			if(num%2 == evenOrOdd%2)
				list.add(num);
		return list;
	}
	public static int getSum(ArrayList<Integer> numList) {
		int sum=0;
		for(int num : numList)
			sum += num;
		return sum;
	}
	public static void printInfo(ArrayList<Integer> numList, String msg) {
		if(numList.isEmpty()) {
			System.out.println(msg + " 목록 : 없음");
			System.out.println(msg + " 합계 : 0, 평균 : 0.0");
			return;
		}
		DecimalFormat df = new DecimalFormat("#0.0");
		System.out.println(msg + " 목록 : " + numList);
		System.out.println(msg + " 합계 : " + getSum(numList) + ", 평균 : " + df.format((double)getSum(numList)/numList.size()));
	}
}
