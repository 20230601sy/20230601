package N02_CallByValue;
public class S01_DataMain {
	public static void main(String[] args) {
		S01_Data d = new S01_Data();
		d.num = 5;
		System.out.println("num : " + d.num);
		d.change(d.num);
		System.out.println("change 호출 후 num : " + d.num); // 변동 없음!
		// 값(내용)을 보낸 거니까 자체 변수 값이 변동이 생길 일은 없음
	}
}