package N01_컬렉션;

import java.util.Stack;

public class S03_Sample03 {

	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(10));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(100));
		
		while(!coinBox.empty()) {
			Coin c = coinBox.pop();
			System.out.println("꺼넨 동전 : "+c.getValue());
		}
	}

}

class Coin{
	private int value;

	public Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}