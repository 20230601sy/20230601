package N02_다형성;

public class S04_TireMain {

	public static void main(String[] args) throws InterruptedException {
		S04_Car c = new S04_Car();
		for(int i=0; i<15; i++) {
			int num = c.run();
//			switch(num) {
//				case 1:
//					System.out.println("앞왼쪽 타이어를 한국타이어로 교체");
//					c.fLTire = new HankookTire(15, "앞왼쪽");
//					break;
//				case 2:
//					System.out.println("앞오른쪽 타이어를 한국타이어로 교체");
//					c.fRTire = new HankookTire(20, "앞오른쪽");
//					break;
//				case 3:
//					System.out.println("뒤왼쪽 타이어를 넥센타이어로 교체");
//					c.bLTire = new NexenTire(17, "뒤왼쪽");
//					break;
//				case 4:
//					System.out.println("뒤오른쪽 타이어를 넥센타이어로 교체");
//					c.bRTire = new NexenTire(13, "뒤오른쪽");
//					break;
//			}
			if(num == 1 || num == 2) {
				System.out.println(c.tires[num-1].location + " 타이어를 한국타이어로 교체");
				c.tires[num-1] = new S04_HankookTire(20, c.tires[num-1].location);
			}
			if(num == 3 || num == 4) {
				System.out.println(c.tires[num-1].location + " 타이어를 넥센타이어로 교체");
				c.tires[num-1] = new S04_NexenTire(17, c.tires[num-1].location);
			}
			System.out.println("==============================");
			Thread.sleep(3000);
		}
	}

}
