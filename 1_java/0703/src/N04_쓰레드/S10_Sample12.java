package N04_쓰레드;

class FlagThread extends Thread{

	private boolean stop = false; // 초기값은 false
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		int i=1;
		while(!stop)
			System.out.println(i++);
		System.out.println("쓰레드 종료");
	}
	
}
public class S10_Sample12 {

	public static void main(String[] args) {
		FlagThread t = new FlagThread(); // Thread t = new FlagThread(); 이걸로 하면 stop flag 사용 못함 
		t.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		t.setStop(true);
		System.out.println("메인 종료");
	}

}
