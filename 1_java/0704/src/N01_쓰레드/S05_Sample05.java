/*
 * 1부터 10까지를 출력하는 쓰레드를 생성
 * 단, 두 쓰레드가 번갈아가면서 숫자를 출력해야 함
 */
package N01_쓰레드;

class WorkObject1 {
	int i;
	public synchronized void methodA() {
		System.out.println(++i);
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
	public synchronized void methodB() {
		System.out.println(++i);
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
class ThreadA1 extends Thread {
	WorkObject1 wo;

	public ThreadA1(WorkObject1 wo) {
		this.wo = wo;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++)
			wo.methodA();
	}
}
class ThreadB1 extends Thread {
	WorkObject1 wo;

	public ThreadB1(WorkObject1 wo) {
		this.wo = wo;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++)
			wo.methodB();
	}
}
public class S05_Sample05 {

	public static void main(String[] args) {
		WorkObject1 wo = new WorkObject1();
		ThreadA1 ta = new ThreadA1(wo);
		ThreadB1 tb = new ThreadB1(wo);
		ta.start();
		tb.start();
		try { Thread.sleep(500); }catch(Exception e) { }
		System.exit(0);
	}
}