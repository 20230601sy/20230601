package N02_스트림;

import java.util.Comparator;
import java.util.stream.Stream;

class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String getName() {  // 클래스명::변수 이렇게 할 수 없으니 게터 메서드를 만들어 놓는 거...
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}

	@Override
	public int compareTo(Student o) {
		return o.totalScore - this.totalScore; // 기본 정렬을 내림차순으로!
	}
	/*
	 * 양수
	 * 0
	 * 음수 라는데...??? 들어온 애가 더 크면 위로 올라가니까 내림차순 되는 건 맞음 ㄷㄷ
	 */
}
public class S03_Sample03 {

	public static void main(String[] args) {
		Stream<Student> stuStream = Stream.of(
										new Student("aaa", 3, 300),
										new Student("bbb", 1, 200),
										new Student("ccc", 2, 100),
										new Student("ddd", 2, 150),
										new Student("eee", 1, 250),
										new Student("qqq", 3, 280),
										new Student("www", 1, 210),
										new Student("rrr", 2, 150)
									);
		System.out.println("반별 정렬 후 점수를 기본 정렬 시킨 결과 출력");
		stuStream.sorted(Comparator.comparing(Student::getBan)
									.thenComparing(Comparator.naturalOrder()))
									.forEach(System.out::println);
	}

}
