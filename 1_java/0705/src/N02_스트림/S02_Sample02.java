package N02_스트림;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class S02_Sample02 {

	public static void main(String[] args) {
		/*
		 * 최종연산
		 * void forEach ( Consumer )
		 * boolean anyMatch 조건에 만족하는 게 있냐 없냐
		 * Optional max, min ( Comparator ) eg. Integer::compareTo
		 * Optional reduce ( BinaryOperator or 메서드 참조 )
		 */
		List<String> list = Arrays.asList("3aaa", "5bb", "1c");
//		list.stream().forEach(System.out::print); // 3aaa5bb1c
		String str = list.stream()
						.collect(Collectors.joining(", "));
//		System.out.println(str); // 3aaa, 5bb, 1c
//		System.out.println(list.stream().count()); // 개수 반환, Long cnt, 3
//		System.out.println(list.stream().filter(s->s.length()>=4).count());
		
		// anyMatch
		List<Integer> intList = Arrays.asList(1, 50, 3, 10, 6);
//		System.out.println(intList.stream().anyMatch(n -> n%2 == 0)); 	// true
//		System.out.println(intList.stream().allMatch(n -> n%2 == 0)); 	// false
//		System.out.println(intList.stream().noneMatch(n -> n%2 == 0)); 	// false
		
//		System.out.println(intList.stream().max(Integer::compareTo));	// Optional[50]
//		Optional<Integer> max = intList.stream().max(Integer::compareTo); // return 타입이 Optional, 제네릭도 있음 헷.
		/*
		 * Optional이라는 걸 왜 쓰는지!
		 * 내가 찾으려고 하는 값이 없었을 경우를 대비한 거!!!
		 * 기본데이터 타입은 NULL을 가질 수 없음 NULLPointerException 바로 발생시킴
		 * 데이터가 비었을 경우 Optional.empty로 명시해줌~ 굳
		 * .get() 으로 내용물 꺼냄
		 * OrElse??? 같은 게 있다시는데 이따가 할 듯 뭔지 모르겠당 헤헷
		 */
//		System.out.println(max.get());
//		System.out.println(intList.stream().min(Integer::compareTo).get());
		
		// reduce, 스트림 데이터를 순차적으로 메소드에 따라 계산해서 값을 Optional로 리턴시켜줌
//		System.out.println(intList.stream().reduce(Integer::sum).get());
	}

}
