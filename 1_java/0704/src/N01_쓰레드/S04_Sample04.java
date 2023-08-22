package N01_쓰레드;

class WorkObject {
	public synchronized void methodA() {
		System.out.println("메서드A 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	public synchronized void methodB() {
		System.out.println("메서드B 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
class ThreadA extends Thread {
	WorkObject wo;

	public ThreadA(WorkObject wo) {
		this.wo = wo;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.print(Thread.currentThread().getName() + " ");
			wo.methodA();
		}
	}
}
class ThreadB extends Thread {
	WorkObject wo;

	public ThreadB(WorkObject wo) {
		this.wo = wo;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.print(Thread.currentThread().getName() + " ");
			wo.methodB();
		}
	}
}
public class S04_Sample04 {

	public static void main(String[] args) {
		WorkObject wo = new WorkObject();
		ThreadA ta = new ThreadA(wo);
		ThreadB tb = new ThreadB(wo);
//		ThreadA tc = new ThreadA(wo);
//		ThreadB td = new ThreadB(wo);
		ta.start();
		tb.start();
//		tc.start();
//		td.start();
	}

}
