package N04_쓰레드;

public class S02_Sample02 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					
				}
				System.out.println("Runnable : Hello");
			}
		}; // 익명클래스로 일회성 구현, ; 로 끝나야 함!!!
		Thread t = new Thread(r);
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					
				}
				System.out.println("Thread : Hello");
			}
		};

		t.start();
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
		}
		System.out.println("main : Hello");
	}

}
