package N02_배열;

public class Sample01 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		int a;
//		System.out.println(a); a를 초기화하지 않은 상태에서 출력하면 에러 발생(실행되지 않음)
		System.out.println(arr); // arr를 출력하면 주소값이 출력됨
		System.out.println(arr[0]); /* 배열의 시작은 0부터! arr[0], arr[1], ... , arr[4] 
									 * 배열은 값을 안 넣어도 값을 알아서 채워놓음
									 * int는 0
									 * double은 0.0
									 * char는 '0'(출력해보면 공백 한칸 나옴)
									 * string은 null (null이라는 게 null이 문자로 저장된 게 아니고 비어있다는 의미)
									 * boolean은 false
									 * 그러니까 특별히 따로 초기화 하지 않아도 기본값으로 초기화되어 있음!
									 */
		// 배열의 초기화는 중괄호를 사용해서함, 배열을 아래 값직접 먼저 
		int[] array = {1, 2, 3, 4, 5};
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
//		System.out.println(array[5]); 범위에 벗어나는 배열값 출력 실행 시 에러발생!
		
		arr[3] = 10; // 특정 배열값 수정은 그냥 대입연산자, 변수랑 똑같이 사용해서 쓰면 됨

		// 배열은 반복문과 뗄레야 뗄 수 없음...
		int x=10, y=20, z=30;
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		for(int i=0; i<3; i++)
			System.out.println(arr[i]); // x, y, z 는 print를 각각 해야 함, 배열은 반복문을 이용하면 입력, 출력을 좀더 용이하게 할 수 있음!
		//배열 너무 어렵게 생각하지는 말고 그냥 변수구나라고 생각...
	}
}
