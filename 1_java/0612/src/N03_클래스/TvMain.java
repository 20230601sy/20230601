package N03_클래스;

import java.util.Scanner;

public class TvMain {
	public static void main(String[] args) {
		Tv lgTv = new Tv();
		lgTv.showInfo(); // 초기화 안했을 때 기본값~~
		lgTv.color = "검정색";
		lgTv.channel = 11;
		lgTv.showInfo();
		
		lgTv.power();
		lgTv.showInfo();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
//			System.out.println("TV전원 On/off [버튼은 1번]");
//			if(sc.nextInt() == 1) {
//				lgTv.power();

			System.out.println("1번 : 전원, 2번 : 채널+, 3번 : 채널-");
			int n = sc.nextInt();
			if(n==1)
				lgTv.power();
			else if(n==2)
				lgTv.channelUp();
			else if(n==3)
				lgTv.channelDown();
			lgTv.showInfo();
		}
	}
}
