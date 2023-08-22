package 증감연산자;
public class Sample01 {
	public static void main(String[] args) {
		int num = 5;
		// num이 1 증가된 값을 출력
		System.out.println(num + 1);
		
		// num을 1 증가시킬 때
		num = num + 1;
		num += 1; // step variable
		++num; --num; // step 1로 고정, 전위연산자
		num++; num--; // step 1로 고정, 후위연산자
		// 출력문 내부에 전위, 후위 연산자를 쓰지는 않기 때문에 보통은 num++; num--;이런식으로 쓴다.
		
		// num을 1 증가시켜 값을 출력
		System.out.println(++num);
		// 출력은 먼저 시키고 num을 1 증가시키기
		System.out.println(num++);
	}
}
