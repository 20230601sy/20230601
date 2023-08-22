/*
 * Employee 클래스
 * 이름 name, 급여 salary
 * 생성자로 이름과 급여를 초기화
 * calcBonus() 메서드: 기본 급여에 5%를 보너스로 처리해서 리턴시킴
 */
package N01_복습;

public class S02_Employee {
	String name;
	int salary;
	public S02_Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

	public int calcBonus() {
		return (int) (salary*0.05);
	}
}
