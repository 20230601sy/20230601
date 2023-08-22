/*
 * Management 클래스
 * 직원들을 배열로 관리
 * totalBonus 메서드 : 직원들의 보너스 총합계를 계산해서 출력
 */
package N01_복습;

public class S02_Management {
	S02_Employee[] employees;
	int numEmployee;
	
	public S02_Management(int size) {
		this.employees = new S02_Employee[size];
		numEmployee = 0;
	}
	
	public void addEmployee(S02_Employee e) {
		employees[numEmployee] = e;
		numEmployee++;
	}

	public void totalBonus() {
		int totalBonus = 0;
//		for(int i=0; i<employees.length; i++) // 나중에 추가할 때마다 500원 받아야겠음 ㅡㅡ
		for(int i=0; i<numEmployee; i++)
			totalBonus += employees[i].calcBonus();
		System.out.println("totalBonus : " + totalBonus);
	}
	public void info() {
		for(int i=0; i<numEmployee; i++)
			System.out.println(employees[i]);			
	}
}
