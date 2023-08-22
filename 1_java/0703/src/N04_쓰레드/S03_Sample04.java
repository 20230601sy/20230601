/*
 * 멀티쓰레드를 하게 되면 
 * 이쪽저쪽 왔다갔다 하는 시간이 추가로 걸림(동시에 충돌되면 priority처리해야 하니까 그런 거일 듯)
 * 우선순위는 1~10인데 설정하지 않으면 기본값은 5로 설정됨
 * Round-Robin 방식 순환 할당 : JVM에서 실행 자원을 할당받은 만큼만 하고 넘기는 거
 * CS 공부하시면 이런 거 공부할 거라심... 시분할 시스템 뭐 이렇거도 있고
 */
package N04_쓰레드;

class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<1000; i++)
			System.out.print("☆");

		long endTime = System.currentTimeMillis();
		System.out.println("☆ 소요시간 : " + (endTime - S03_Sample04.startTime));
	}
}

public class S03_Sample04 {

	static long startTime;
	
	public static void main(String[] args) {
		Thread t = new MyThread();
		t.setPriority(1);
		startTime = System.currentTimeMillis();
		t.start();		
		
		for(int i=0; i<1000; i++)
			System.out.print("★");

		long endTime = System.currentTimeMillis();
		System.out.println("★ 소요시간 : " + (endTime - startTime));
	}

}
