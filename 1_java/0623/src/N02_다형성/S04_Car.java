package N02_다형성;

public class S04_Car {
	
//	Tire fLTire = new Tire(6, "앞왼쪽"); // 여기에 한국타이어를 넣든, 넥센을 넣든 상관 없는데 선언을 할 때 Tire로 해놔야 가능하다는 거!
//	Tire fRTire = new Tire(3, "앞오른쪽");
//	Tire bLTire = new Tire(8, "뒤왼쪽");
//	Tire bRTire = new Tire(10, "뒤오른쪽");
	
	S04_Tire[] tires = {
			new S04_Tire(6, "앞왼쪽"),
			new S04_Tire(3, "앞오른쪽"),
			new S04_Tire(8, "뒤왼쪽"),
			new S04_Tire(10, "뒤오른쪽")
	};
	
	public void stop() {
		System.out.println("자동차 멈춤");
	}
	
	public int run() {
		System.out.println("자동차 주행 시작");
		
//		if(!fLTire.roll()) {
//			stop();
//			return 1;
//		}
//		if(!fRTire.roll()) {
//			stop();
//			return 2;
//		}
//		if(!bLTire.roll()) {
//			stop();
//			return 3;
//		}
//		if(!bRTire.roll()) {
//			stop();
//			return 4;
//		}
		
		for(int i=0; i<tires.length; i++) {
			if(!tires[i].roll()) {
				stop();
				return i+1;
			}
		}
		
		return 0;
	}
}
