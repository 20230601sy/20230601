// 로또 번호 생성 다른 방법
package N02_배열;

import java.util.Arrays;

public class Sample09 {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int num = 45; // 45로 하면 너무 확인하기 어려우니까 6으로 줄여서 1~6이 잘 나오는지 확인
		
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*num)+1;
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(lotto));
	}
}
