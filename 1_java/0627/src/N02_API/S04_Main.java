package N02_API;

import java.text.DecimalFormat; // import 해야 함!

public class S04_Main {

	public static void main(String[] args) {
		int num = 1234567;
		System.out.println(num);
		DecimalFormat df = new DecimalFormat("#,###"); // ,는 자리수 구분기호, 0이나 #은 숫자임 
		System.out.println(df.format(num));
		
		double num2 = 1234567.897;
		df = new DecimalFormat("#,##0.000"); // 0은 자리수 채워줌, 일의자리 0은 0.12 같은 게 .12처럼 나오는 거 방지
		System.out.println(df.format(num2)); // 변환된 데이터는 결과값은 문자열이기 때문에 연산은 안됨... 걍 눈으로 볼 때 예쁘게 보는 용도 
	}

}
