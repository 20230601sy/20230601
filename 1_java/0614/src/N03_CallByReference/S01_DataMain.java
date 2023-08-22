package N03_CallByReference;

public class S01_DataMain {
	public static void main(String[] args) {
		S01_Data data = new S01_Data();
		data.num = 5;
		System.out.println("num : " + data.num);
		data.change(data); // 아까처럼 d.num을 넣을 수 없음!
		System.out.println("change 호출 후 num : " + data.num); // 변동 있음!
		// new Data()를 실행하면 data에 주소값이 들어가는 거임 (메모리 어느 한 구석에 저장공간을 할당하는 거)
		S01_Data data2 = data; // 이렇게 하면 같은 주소값이 들어가는거지 인스턴스가 새로 생성되는 것은 아님
		System.out.println("data2.num : " + data2.num);
		S01_Data data3 = data.copy(data);
		System.out.println("data3.num : " + data3.num);
	}
}