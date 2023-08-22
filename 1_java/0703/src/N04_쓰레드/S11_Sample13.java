package N04_쓰레드;

class DepreThread implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
}

public class S11_Sample13 {

	public static void main(String[] args) {
		Thread[] t = new Thread[3];
		for(int i=0; i<t.length; i++) {
			t[i] = new Thread(new DepreThread(), "쓰레드"+(i+1));
			t[i].start();
		}
		try {
			Thread.sleep(2100);
			t[0].suspend();
			Thread.sleep(2100);
			t[1].suspend();
			Thread.sleep(2100);
			t[0].resume();
			Thread.sleep(2100);
			t[2].stop();
			t[1].resume();
			Thread.sleep(2100);
			t[0].stop();
			t[1].stop();
		} catch (InterruptedException e) {
		}
		System.out.println("메인 종료");
	}

}
