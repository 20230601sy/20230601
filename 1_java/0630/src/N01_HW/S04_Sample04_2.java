/*
 * 두개의 문자열을 입력받음
 * 공통된 문자를 출력
 */
package N01_HW;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class S04_Sample04_2 {
	
	static int cnt = 0;
	
	public static void main(String[] args) {

		String str1 = scanStr();
		String str2 = scanStr();
		
		Set<Character> set1 = convert(str1);
		Set<Character> set2 = convert(str2);
		Set<Character> setKyo = intersection(set1, set2);
		
		System.out.println("공통된 문자 : " + setKyo);
		
	}
	
	public static String scanStr() {
		cnt++;
		Scanner sc = new Scanner(System.in);
		System.out.print(cnt + "번째 문자열 입력 : ");
		return sc.next();
	}
	public static Set<Character> convert(String str){
		Set<Character> set = new HashSet<>();
		for(int i=0; i<str.length(); i++)
			set.add(str.charAt(i));
		return set;
	}
	public static Set<Character> intersection(Set<Character> set1, Set<Character> set2){
		Set<Character> intersection = new HashSet<>();
		intersection.addAll(set1);
		intersection.retainAll(set2);
		return intersection;
	}
}
