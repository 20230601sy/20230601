package N04_쓰레드;

import javax.swing.JOptionPane;

class Th extends Thread{

	@Override
	public void run() {
		for(int i=0; i<30; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
			}catch(Exception e) {
				
			}
		}
	}
	
}
public class S04_Sample06 {
	public static void main(String[] args) {
		System.out.println("메인 쓰레드 시작==========");
		Thread t = new Th();
		t.start();
		String input = JOptionPane.showInputDialog("입력");
		System.out.println("입력 : " + input);
		System.out.println("메인 쓰레드 종료==========");
	}

}
