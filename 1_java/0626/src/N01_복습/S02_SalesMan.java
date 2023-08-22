/*
 * SalesMan 클래스 - Employee 클래스를 상속
 * calcBonus 메서드를 오버라이딩 구현, 기본 급여에 15%를 보너스로 처리해서 리턴시킴
 */
package N01_복습;

public class S02_SalesMan extends S02_Employee {
	public S02_SalesMan(String name, int salary) {
		super(name, salary);
	}

	@Override
	public String toString() {
		return "SalesMan [name=" + name + ", salary=" + salary + ", calcBonus()=" + calcBonus() + "]";
	}

	@Override
	public int calcBonus() {
		return (int) (salary*0.15);
	}
	
}
