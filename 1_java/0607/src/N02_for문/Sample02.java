// 1~100까지 합계
package N02_for문;

import java.text.SimpleDateFormat;

public class Sample02 {

	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=100; i++) {
//			System.out.println(i);
			sum += i;
		}
		System.out.println("합계 : " + sum);
		
		
		long start = System.currentTimeMillis();
		for(int i=1; i<=100000; i++) {
			sum += i;
		}
		long finish = System.currentTimeMillis();
		System.out.println("합계 : " + sum);
		System.out.println("timeElapsed : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(finish - start));
		start = System.currentTimeMillis();
		System.out.println("합계 : " + 100000*100001/2);
		finish = System.currentTimeMillis();
		System.out.println("timeElapsed : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(finish - start));
		/*
		 * 합계 : 705082704
		 * timeElapsed : 1970-01-01 09:00:00.002
		 * 합계 : 705082704
		 * timeElapsed : 1970-01-01 09:00:00.000
		 */
	}

}
