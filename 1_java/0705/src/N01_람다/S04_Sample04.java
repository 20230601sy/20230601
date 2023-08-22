package N01_람다;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

@FunctionalInterface
interface NumberOperator {
	int operate(int n1, int n2);
}
/*
 * 람다 연습2
 * 인터페이스를 구현하고, 람다 표현식을 작성해서
 * 배열에 저장되어 있는 값 중 최대값과 최소값을 출력
 */
@FunctionalInterface
interface Ex2 {
	void printInfo(int[] nums);
}

public class S04_Sample04 {

	public static void main(String[] args) {
		NumberOperator add = (n1, n2) -> n1+n2;
		NumberOperator sub = (n1, n2) -> n1-n2;
		NumberOperator mul = (n1, n2) -> n1*n2;
		System.out.println("===============람다 연습1===============");
		System.out.println("두 개의 정수를 받아서 합계 구하는 거	: " + add.operate(10, 20));
		System.out.println("두 개의 정수를 받아서 빼기 구하는 거	: " + sub.operate(10, 20));
		System.out.println("두 개의 정수를 받아서 곱하기 구하는 거	: " + mul.operate(10, 20));
		
		System.out.println("===============람다 연습2===============");
		int[] arr = { 5, 10, 3, 7, 6, 11 };
		Ex2 ex2 = (nums) -> {
//			try {
//				int max = nums[0];
//				int min = nums[0];
//			for(int num:nums) {
//				if(num<min)
//					min = num;
//				if(num>max)
//					max = num;
//			}
//			System.out.println("최대값 : " + max + ", 최소값 : " + min);
//			} catch(Exception e) {
//				System.out.println("배열 길이 : 0");
//			}
			TreeSet<Integer> t = new TreeSet<>();
			for(int n:arr)
				t.add(n);
			System.out.println("최대값 : " + t.last() + ", 최소값 : " + t.first());
		};
		ex2.printInfo(arr);
	}
}
