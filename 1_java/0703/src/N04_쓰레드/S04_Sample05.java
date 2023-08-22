package N04_쓰레드;

import javax.swing.JOptionPane;

public class S04_Sample05 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("입력");
		for(int i=0; i<30; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
			}catch(Exception e) {
				
			}
		}
	}

}
