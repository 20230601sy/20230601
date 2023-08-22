package N02_API;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class S03_Main {

	public static void main(String[] args) throws ParseException {
		
		Calendar today = Calendar.getInstance(); // 우리가 배웠던 싱글톤과 유사한 구조, Calendar는 import해야 함
//		today.clear();
//		today.set(2023, Calendar.JUNE, 27);
//		System.out.println(today);
//		System.out.println();
//		today.set(2023, Calendar.JUNE, 28);
//		System.out.println(today); // 이건 연월일만 딱 세팅해줌...요일 안 바뀌는 듯???
		
		System.out.println(today); // 1970년 1월 1일부터 흐른 mSec 단위
		System.out.println("년도 : " + today.get(Calendar.YEAR));
		System.out.println("월  : " + (today.get(Calendar.MONTH) + 1)); // Month는 0~11로 출력되어서 +1 해야 함!
		String[] arr = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};// 이건 열거형 나중에 배우면 이거보다 간단하게 한다심
		System.out.println("일 : " + today.get(Calendar.DATE)); // Day가 아니고 DATE임!
		// 요일은 1~7, 일~토 임!
		String[] warr = {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"}; // 형태라는 거지
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("2023-06-28");
		sdf = new SimpleDateFormat("EE");
		System.out.println(sdf.format(d));

//		Date now = new Date();
//		System.out.println(now);
//		SimpleDateFormat f;
//		f = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
//		System.out.println("yyyyy-MM-dd a hh:mm:ss : " + f.format(now)); // 2023-06-27 오후 01:20:25
//		f = new SimpleDateFormat("yy-MM-dd HH:m:s");
//		System.out.println("yy-MM-dd HH:m:s	: " + f.format(now)); // 23-06-27 13:21:32
//		f = new SimpleDateFormat("yy-M-d");
//		System.out.println("yy-M-d	: " + f.format(now)); // 23-6-27
//		f = new SimpleDateFormat("yy-MMM-d");
//		System.out.println("yy-MMM-d	: " + f.format(now)); // 23-6월-27, 설정 언어에 따라가나봄
	}

}
