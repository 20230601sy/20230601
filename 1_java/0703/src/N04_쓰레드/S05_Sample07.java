package N04_쓰레드;

class Thread1 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<300; i++)
			System.out.print("☆");
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<300; i++)
			System.out.print("★");
	}
}
public class S05_Sample07 {
	public static void main(String[] args) {

		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		System.out.println("기본 우선 순위 : " + t1.getPriority());
		System.out.println("기본 우선 순위 : " + t2.getPriority());
		
		t1.setPriority(10);
		t2.setPriority(1);
		System.out.println("변경 후 우선 순위 : " + t1.getPriority());
		System.out.println("변경 후 우선 순위 : " + t2.getPriority());
		
		t1.start();
		t2.start();
	}
}
