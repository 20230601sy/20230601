/*
 * s 객체를 생성
 * name, age에 값을 넣어주고 싶음
 * s.name, s.age에 넣어 주면 됐징
 * 그런데, 메인에서 이름, 나이를 입력받고 이름과 나이를 멤버변수에 저장하는 메서드를 만들고 싶으면?
 * → setName, this 설명!
 * 이름을 main으로 가져오는 메서드는 어떻게 만들까?
 * → getName
 * 나중에 이런 함수, 게터랑 세터라고 하는데 이런 걸 자주 만든다심... 으어 이거 생각나려고 해 ㅡ_ㅡ 
 * 이걸 이클립스가 자동으로 만들어 주는 것도 있음! 지금은 그것까지 볼 필요는 없다심
 * 지금은 this가 왜 필요한지가 중요한 게 아니라 어떤 역할을 하는구나 이해만 하라심
 */
package N01_this;

public class S01_sample {
	String name;
	int age;
	public void setName(String name) {
		this.name = name; // this는 자기 자신(클래스)를 의미
						  // 매개변수와 멤버변수가 구분이 안될 때 사용
						  // 접근제한자 + 캡슐화 배울 때 왜 이렇게 쓰는지 배울 예정이라심
	}
	public String getName() {
		return name;
	}
}
