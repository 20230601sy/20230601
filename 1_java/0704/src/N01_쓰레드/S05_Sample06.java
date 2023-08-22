/*
 * 1부터 10까지를 출력하는 쓰레드를 생성
 * 단, 두 쓰레드가 번갈아가면서 숫자를 출력해야 함
 */
package N01_쓰레드;

class NumThread extends Thread {
	String name;
	int num;
	Object lock;

	public NumThread(String name, int num, Object lock) {
		this.name = name;
		this.num = num;
		this.lock = lock;
	}

	@Override
	public void run() {
		while(num<=10) {
			synchronized(lock) {
				System.out.println(name + " : " + num);
				num = num+2;
				lock.notify();
				try {
					lock.wait();
				} catch (Exception e) {
				}
			}
		}
	}
}
public class S05_Sample06 {

	public static void main(String[] args) {
		
		Object lock = new Object();
		NumThread ta = new NumThread("A", 1, lock);
		NumThread tb = new NumThread("B", 2, lock);
		ta.start();
		tb.start();
		try { Thread.sleep(500); }catch(Exception e) { }
		System.exit(0);
	}
}