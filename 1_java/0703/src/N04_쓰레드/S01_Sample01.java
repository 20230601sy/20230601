/*
 * Thread 쓰레드 506p
 * 메인프로그램 실행시키면 쓰레드 작동되어 알게 모르게 사용하고 있었음... 
 * 메인이 작동되는 동안 별도의 쓰레드도 작동이 될 수 있게끔 
 * 여러 개의 코드가 동시에 작동되는 거를 쓰레드로 작동되어
 * 원래 메인이 끝나면 종료되던 걸
 * 병렬로 코드들이 동시에 처리된다고 생각하면 됨
 * 여러개 동시에 실행시키는 거.
 * 예를 들어 스캐너를 입력받는 동안 아무 것도 못했는데, 별도의 쓰레드를 하면 
 * 
 * 기본적으로 쓰레드 클래스를 상속받아서, 혹은 러너블이라는 인터페이스를 구현
 * 원래는 두가지가 더있어서 총 4가지라심 (익명 클래스로 하는 거랑 람다 사용하는 거)
 * 
 * 동시에 처리되기 때문에 생기는 문제도 있다시지만 지금은 그냥 넘어간다심
 */
package N04_쓰레드;

// 쓰레드 구현 1. Thread 클래스 상속
class MyThread1 extends Thread {
	@Override
	public void run() { // 쓰레드를 실행시킬 때 실행시키는 메서드, 원하는 대로 구현하려면 오버라이딩해줘야 함!
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
			System.out.println("1 : " + getName()); // Thread에 getName()이 구현되어 있고, 쓰레드 클래스명 출력해줌
		}
	}
}

// 쓰레드 구현 2. Runnable 인터페이스를 구현 
class MyThread2 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
			System.out.println("2 : " + Thread.currentThread().getName()); // 인터페이스라 바로 호출 못함
		}
	}
}
public class S01_Sample01 {

	public static void main(String[] args) {
		Thread t = new MyThread1(); // 보통은 부모 클래스인 Thread로 쓴다심!
		Runnable r = new MyThread2(); // 인터페이스를 구현한 것은 Runnable로 만든 후 Thread에 넣어 줘야 함!
		Thread t2 = new Thread(r); // 인터페이스를 구현한 것은 여기까지 해야 사용할 수 있음!
		
		t.start(); // run 메서드를 호출하는 거긴 한데, .run으로 호출하면 메인에서 그냥 호출하는 거로 별도의 쓰레드를 사용되는 게 아님, start로 호출해야 별도의 쓰레드로, 실행되는 영역이 나뉘어 동작됨
		t2.start(); // 우선순위를 지정해주는 메서드는 있지만 매번 100프로 지정되는 것은 아니라심 signal과 동일함ㅎ 
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
		}
		System.out.println("5초 후 main 종료");
	}
}
