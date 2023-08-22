// 로또 번호 생성, 책 140p에 있는 거 그대로 설명
package N02_배열;
public class Sample08 {
	public static void main(String[] args) {
		int[] ball = new int[45];
		
		for(int i=0; i<ball.length; i++)
			ball[i] = i+1;
		
		int j, tmp;
		for(int i=0; i<6; i++) {
			j = (int)(Math.random()*45);
			tmp = ball[i];
			ball[i] = ball[j];
			ball[j] = tmp;
			System.out.print(ball[i] + " ");
		}
	}
}
