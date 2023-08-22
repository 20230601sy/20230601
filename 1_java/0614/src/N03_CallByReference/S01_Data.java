package N03_CallByReference;
public class S01_Data {
	int num;
	public void change(S01_Data data) {
		System.out.println("data.num : " + data.num);
		data.num = 1000;
		System.out.println("change메서드 호출 num : " + data.num);
	}
	public S01_Data copy(S01_Data data) { // 리턴도 배열, 객체 다 가능!
		S01_Data d = data;
		
		S01_Data d2 = new S01_Data();
		d2.num = data.num;
		return d; // return d2;
	}
}