// 224p 예제
package N02_상속;

public class S02_Tv {
	boolean power;
	int channel;
	public void power() {
		power = !power;
	}
	public void channelUp() {
		channel++;
	}
	public void channelDown() {
		channel--;
	}
}
