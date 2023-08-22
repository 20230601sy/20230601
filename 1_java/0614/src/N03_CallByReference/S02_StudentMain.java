package N03_CallByReference;

public class S02_StudentMain {

	public static void main(String[] args) {
		S02_Student stu = new S02_Student();
		stu.score[0] = 80;
		stu.score[1] = 90;
		stu.score[2] = 70;
		
		int sum = stu.add(stu.score); // 80, 90, 70을 각각 보내주는 게 아니라 배열의 주소를 보내면 한 번에 보낼 수 있음!
		System.out.println("sum : " + sum);
	}

}
