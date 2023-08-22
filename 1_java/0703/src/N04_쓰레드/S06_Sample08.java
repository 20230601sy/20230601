package N04_쓰레드;

class A implements Runnable{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 시작");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " 종료");
		
	}
	
}

public class S06_Sample08 {

	public static void main(String[] args) {
		ThreadGroup g = new ThreadGroup("그룹명"); // 그룹명은 알아서 작명해~, 그룹명이란 그룹만 일단 만들어진 상태
		Thread t1 = new Thread(g, new A(), "쓰레드1"); // t1에 대한 이름도 "쓰레드1"로 지정해줄 수 있음!
		Thread t2 = new Thread(g, new A(), "쓰레드2");
		t1.setPriority(10);
		t1.start();
		t2.start();
		g.list(); // java.lang.ThreadGroup[name=그룹명,maxpri=10] Thread[쓰레드1,10,그룹명] Thread[쓰레드2,5,그룹명]
		try {
			Thread.sleep(2000);
			System.out.println("현재 실행 중인 쓰레드 수 : " + g.activeCount());
		} catch (InterruptedException e) {
		}
	}

}
