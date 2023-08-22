package N03_클래스;
public class Tv {
	String color;
	boolean power;
	int channel;
	
	public void power() { // public 써야 함! 보통 메서드 이름은 기능이기 때문에 동사형태로 씀. 이런 식으로는 잘 안 씀 
		power = !power;
	}
	public void channelUp() {
		channel++;
	}
	public void channelDown() {
		channel--;
	}
	public void showInfo() {
		if(power)
			System.out.println("전원 : 켜짐");
		else
			System.out.println("전원 : 꺼짐");
		System.out.println("TV 색상 : " + color);
		System.out.println("현재 채널 : " + channel);
	}
}
