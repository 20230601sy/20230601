package N03_람다;

@FunctionalInterface
interface Study {
	public void gugudan(int n);
}

@FunctionalInterface
interface Study2 {
	public int sum(int[] arr);
}
public class S02_Sample02 {

	public static void main(String[] args) {
		Study s = n -> {
			for(int i=1; i<=9; i++)
				System.out.println(n + "*" + i + "=" + n*i);
		};
		s.gugudan(9);
		
		Study2 s2 = arr -> {
			int sum = 0;
			for(int i=0; i<arr.length; i++)
				sum += arr[i];
			return sum;
		};
		int[] arr = { 80, 90, 100, 30, 40 };
		System.out.println(s2.sum(arr));
	}
}
