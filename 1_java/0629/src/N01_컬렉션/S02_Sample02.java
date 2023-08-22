/*
 * 중복된 단어 찾기
 * 문장을 저장하는 변수에 문장을 알아서 넣고 시작
 * 단어는 공백 기준으로 구분
 * 중복된 단어가 없으면 '중복 단어 없음' 출력
 * 있으면 중복된 단어들 출력
 */
package N01_컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class S02_Sample02 {

	public static void main(String[] args) {
		String str = "I got a boy, 멋진, I got a boy, 착한 "
					+ "I got a boy, handsome boy, 내 맘 다 가져간 "
					+ "I got a boy, 멋진, I got a boy, 착한 "
					+ "I got a boy, awesome boy, 완전 반했나";
		String[] data = str.split(" ");
//		System.out.println(Arrays.toString(data));
		
		// 아침에 한 거
//		HashMap<String, Integer> map = new HashMap<>();
//		for(String d : data)
//			map.put(d, map.get(d)==null? 1:map.get(d)+1);
//		System.out.print("중복된 단어 : ");
//		for(String k : map.keySet())
//			if(map.get(k)>1)
//				System.out.print(k + " ");
//		if(map.isEmpty())
//			System.out.println("없음");
		
		// ArrayList 사용해볼까~
//		ArrayList<String> al = new ArrayList<>();
//		ArrayList<String> reAl = new ArrayList<>(); // 중복된 것만 넣읍시다!
//		for(String d : data) {
//			if(al.contains(d) && !reAl.contains(d))
//				reAl.add(d);
//			al.add(d);
//		}
//		if(reAl.isEmpty())
//			System.out.println("중복 단어 없음");
//		else
//			System.out.println(reAl);

		// HashSet 사용~~
		HashSet<String> words = new HashSet<>();
		HashSet<String> dupWords = new HashSet<>();
		for(String word : data)
			if(!words.add(word))
				dupWords.add(word);
		if(dupWords.isEmpty())
			System.out.println("중복 단어 없음");
		else
			System.out.println(dupWords);
				
	}

}
