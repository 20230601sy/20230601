package N04_쓰레드;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class B implements Runnable{
	String name;
	
	public B(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " " + name + " 시작");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " " + name + " 종료");
		
	}
	
}

public class S07_Sample09 {

	public static void main(String[] args) {
		// ExecutorService 쓰레드의 생명주기(life cycle)를 담당하는 인터페이스, 기본적으로 인터페이스는 객체 인스턴스 생성이 안되니까 메서드를 활용함 
		ExecutorService es = Executors.newFixedThreadPool(3); // 매개변수는 크기 지금은 쓰레드 3개짜리
		// 생명주기 : 생성 실행 종료 삭제
		
		es.execute(new B("abc")); // 매개변수 안에는 실행시킬 쓰레드가 들어가야 함
		es.shutdown(); // 실행되는 쓰레드까지만 실행시키고 풀을 중지시키는 거도 있음
//		es.shutdownNow(); // 이거는 걍 강제 종료인 듯, 언급은 안 됐지만 걍 있길래 봄ㅎ
		
		for(int i=0; i<10; i++)
			es.execute(new B("B"+(i+1)));
	}

}
