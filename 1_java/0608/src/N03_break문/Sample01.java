package N03_break문;

public class Sample01 {

	public static void main(String[] args) {
		int i;
		for(i=1; i<=100; i++) {
			if(i==51)
				break;
			System.out.println(i);
//			if(i==50)
//				break;
		}
	}
}
