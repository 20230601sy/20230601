/*
 * 스트림 568p
 * 약간 iterator 같은 거라고 생각하시면 된다심
 * 여러개의 타입들의 데이터를 다룰 때 각각의 방식으로 기억을 하는 불편을 해소
 * 여러 타입들의 데이터를 단일화 시켜서 공통적인 메서드로 사용을 할 수 있도록 하는 거.
 */
package N02_스트림;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class S01_Sample01 {

	public static void main(String[] args) {
		String[] strArr = { "3aaa", "5bb", "1c" };
		List<String> strList = Arrays.asList(strArr);
//		System.out.println(strList);
		
		Stream<String> s1 = Arrays.stream(strArr); // 배열만 Arrays를 사용
		Stream<String> s2 = strList.stream(); // 배열 빼고는 모두 .stream()
		
//		System.out.print("배열 데이터를 사용한 결과	: "); // 1ccc3aaa5bbb
//		s1.sorted().forEach(System.out::print); // 오호. (str)->System.out.print(str) 이랑 같은 거! 메서드 호출!
//		System.out.println();
//		System.out.print("컬렉션 데이터를 사용한 결과	: "); // 1ccc3aaa5bbb
//		s2.sorted().forEach(System.out::print); // 배열 데이터를 사용한 방식과 동일한 방식으로 컬렉션 데이터를 사용할 수 있다는 거!
//		System.out.println();
		// 중간에 처리를 하는 sorted()는 중간연산이라하고, forEach() 출력이나 반환 같은 거 하는 걸 최종연산이라 한다심. 종류는 조금 이따가 볼거라심
		/*
		 * 스트림의 특징
		 * 1. 스트림은 데이터 소스를 변경하지 않는다. 기존 데이터가 변경되지 않아서 새로 담아야 하는데, 또 그건 귀찮으니까 반환시켜주는 최종연산이 또 있나봄
		 * 2. 스트림은 일회용이다. // 다시 쓰려면 s2 = strList.stream(); 같은 거 무조건 해야 s2.연산 가능
		 * 3. 스트림은 작업을 내부 반복으로 처리한다. // 향상된 for문도 같은 개념인 건가? 
		 *    이터레이터, 컬렉션은 외부반복. hasNext() next() 했던거 우리가 컨트롤 했던 거.
		 * 4. 지연된 연산, 최종 연산이 수행되기 전까지 중간 연산이 수행되지 않음, 정확하게 필요한 것만 작업을 해서 불필요한 것을 하지 않는 것이 특징
		 * 5. Stream<Integer> vs IntStream 제네릭 생략 가능한 IntStream에는 int에 특화된 메서드들이 추가로 있다심...
		 * 6. 병렬 스트림 : 작업을 분산처리 할 수 있다보니깐 작업의 성능이 향상될 가능성이 있음. 병렬 처리가 복잡도에 따라 성능이 향상되기도 하지만 떨어질 수도 있어서 병렬처리가 무조건 장점이 되지는 않는다심
		 */
		
//		Stream<Integer>
		IntStream is = new Random().ints(); 	// Int로 설정할 수 있는 모든 범위중에서 랜덤 픽
		is = new Random().ints(1, 11); 			// 1부터 10!까지 랜덤하게 하려면 매개변수를 넣어주면 됨
		is = new Random().ints(1, 11).limit(4); // 개수를 제한하는 중간 연산 limit!
//		is.forEach(System.out::println);
		
		is = IntStream.range(1, 5); 			// 1에서 5전까지
//		is.forEach(System.out::println);		// 1, 2, 3, 4
		is = IntStream.rangeClosed(1, 5); 		// 1에서 5 포함까지
//		is.forEach(System.out::println);		// 1, 2, 3, 4, 5
		// python range(n)은 없나봄... 애쉽...
		
		is = IntStream.iterate(0, n->n+2); 		// iterate(초기값, 람다식), 근데 마찬가지로 이러면 안 끝남!
		is = IntStream.iterate(0, n->n+2).limit(5);
//		is.forEach(System.out::print); 			// 02468
		
		is = IntStream.generate(()->5).limit(5); // generate(매개변수 없는 람다식), return 값으로 꽉 채운 데이터 반환됨...
//		is.forEach(System.out::print);			 // 55555
//		System.out.println();
		
		// 파일과 빈 스트림은 파일 입출력할 때 한다심~
		/*
		 * 스티림의 연산
		 * 중간 연산
		 * distinct() : 중복 제거
		 * ....으로 연결되어 있다고 해서 메서드 체이닝~라고 하기도 함. 뭐 용어가 중요한 건 아님~하고 넘어가심!
		 * filter( Predicate <T> p ) : 조건에 만족하는 것만 리턴
		 * map ( R Function <T> f ) : 데이터를 반환해서 새로운 스트림으로 생성, 보통 자료형 변환할 때 사용, 스핀오프로 mapToDouble 등등 있음
		 * sorted : 정렬 (기준은 Comparator로 이따가 할 거라심)
		 * flatMap : 평면화된 스트림을 생성
		 * limit(long n) : 아까 했어... 스트림의 일부를 잘라낸다. 앞에서부터 n개
		 * skip(long n) : n개 건너뜀
		 * peek : 주어진 기능만 작동하고, 스트림은 건드리지 않음. 아무런 기능을 하지는 않지만...엄청 많이 중간연산을 하는 중간쯤에서 중간 처리 결과를 확인하기 위해서 사용 
		 * 중간연산은 순서가 결과에 영향을 미침. 처음부터 처리 시작함.
		 */
		List<Integer> iList = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> iS = iList.stream().filter(n -> n%2==0);
//		iS.forEach(System.out::print); // 24
		iS = strList.stream().map(String::length); // strList = [3aaa, 5bb, 1c];
//		iS.forEach(System.out::print); // 432
		
		// 연관된 거는 한 줄로 쓰긴 하지만. 잘 보이려면 한줄씩 쓰고 주석처리 하면 가독성이 높아진다심
		IntStream lotto = new Random().ints(1,46) 	// 난수 1~45까지 스트림 생성 
										.distinct() // 중복 제거
										.limit(5)	// 5개로 제한
										.sorted();  // 정렬
//		lotto.forEach(System.out::println);
		
		// flatMap 예제~ ㄷㄷ
		List<List<Integer>> numbers = Arrays.asList(
												Arrays.asList(1, 2),
												Arrays.asList(3, 4, 5, 6),
												Arrays.asList(7, 8, 9)
										);
		List<Integer> flatNumbers = numbers.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(flatNumbers);// [1, 2, 3, 4, 5, 6, 7, 8, 9]
		iS = flatNumbers.stream().skip(5);
		iS.forEach(System.out::print);	// 6789
		
	}
}
