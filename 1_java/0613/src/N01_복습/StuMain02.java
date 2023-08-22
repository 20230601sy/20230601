package N01_복습;

public class StuMain02 {

	public static void main(String[] args) {
		int[] a = new int[5];
		Student[] std = new Student[30];
		/*
		 * 객체를 배열로 생성하면 추가로 신경써야 할 것이
		 * 위에서는 방은 존재하는데 객체가 생성되지 않음
		 * 아래처럼 각 배열방에 객체(정확히는 인스턴스)를 생성해주세요 해야 함
		 * 배열방만 생성시에는 std[0].name 출력하면 에러 발생됨
		 * 교재로는 169p
		 */
		for(int i=0; i<std.length; i++){
			std[i] = new Student();
			std[i].name = "학생"+(i+1);
			std[i].age = 18;
			std[i].phone = "010-1234-56"+(i+1);
			System.out.print(i+1+" 학생 정보 → ");
			std[i].showInfo();
		}
	}

}
