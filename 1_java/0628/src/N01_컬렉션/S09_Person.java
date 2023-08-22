package N01_컬렉션;

import java.util.Objects;

public class S09_Person implements Comparable<S09_Person>{
	String name;
	int age;
	public S09_Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override // implements Comparable<S09_Person>
	public int compareTo(S09_Person o) {
		return this.age - o.age; // Ascending
//		return o.age - this.age; // Descending
	}
	
	//
	@Override
	public int hashCode() { // 인스턴스 주소값을 보여주는 거임, Set에서 이걸 보고 비교함
//		return age; // 나이만 중복이 안되게 하려면 간단히.
		return Objects.hash(name,age);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof S09_Person))
			return false; 
		S09_Person p = (S09_Person) obj;
		return this.name.equals(p.name) && (this.age==p.age); 
	}
}
