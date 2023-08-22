package N04_쓰레드;
class ThreadA extends Thread{
	boolean stop;
	boolean work = true;
	
	@Override
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			if(work)
				System.out.println("쓰레드A 작동중");
			else {
				System.out.println("쓰레드A 양보중");
				Thread.yield();
			}
		}
		System.out.println("쓰레드A 종료");
	}
}

class ThreadB extends Thread{
	boolean stop;
	boolean work = true;
	
	@Override
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			if(work)
				System.out.println("쓰레드B 작동중");
			else {
				System.out.println("쓰레드B 양보중");
				Thread.yield();
			}
		}
		System.out.println("쓰레드B 종료");
	}
}

class SumThread extends Thread{
	int sum=0;
	@Override
	public void run() {
		for(int i=1; i<=100; i++)
			sum += i;
	}
}
public class S12_Sample14 {

	public static void main(String[] args) {
		ThreadA ta = new ThreadA();
		ThreadB tb = new ThreadB();
		ta.start();
		tb.start();
		try {
			
			Thread.sleep(3);
			ta.work = false;
			System.out.println("A 양보 시작");
			Thread.sleep(3);
			ta.work = true;
			System.out.println("A 작동 재시작");
			Thread.sleep(3);
			tb.work = false;
			ta.work = false;
			System.out.println("A, B 동시 양보 시작");
			Thread.sleep(3);
			ta.stop = true;
			tb.stop = true;
			System.out.println("A, B 종료");
		} catch (InterruptedException e) {
		}
		SumThread s = new SumThread();
		s.start();
		try {
			s.join(); // join은 예외처리를 강요함...
		} catch (InterruptedException e) {
		}
		System.out.println("sum 결과 : " + s.sum);
	}

}
