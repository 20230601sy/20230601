package N02_다형성;

import java.util.Scanner;

public class S06_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		S06_Driver d = new S06_Driver("홍길동");
		System.out.print("어떤 거 운행하심? [1] 버스 [2] 택시 : ");
		int ch = sc.nextInt();
		if(ch == 1)
			d.drive(new S06_Bus());
		else
			d.drive(new S06_Taxi());
	}

}
