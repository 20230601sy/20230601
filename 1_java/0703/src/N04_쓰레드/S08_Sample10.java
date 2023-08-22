package N04_쓰레드;
class C implements Runnable{

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
				System.out.println("자동 저장");
			} catch (InterruptedException e) {
			}
		}
	}
	
}
public class S08_Sample10 {

	public static void main(String[] args) {
		Thread t = new Thread(new C());
		t.setDaemon(true);
		t.start();
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i+1);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("메인 종료");
			
	}

}
