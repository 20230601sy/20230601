/*
 * Employee클래스는 name, salary, department를 가지고 있음
 * 1. setSalary(int salary): 연봉을 설정함, 단, 연봉은 음수 안됨
 * 2. getSalary(): 연봉을 반환함
 * 3. setDepartment(String department): 부서를 설정함
 * 4. getDepartment(): 부서를 반환함
 * 5. applyBonus(double percent): 주어진 퍼센트만큼 보너스를 직원 연봉에 적용시킴
 * 6. printInfo(): 직원의 정보를 출력
 * <실행 화면>
 * Name: John Doe
 * Salary: $55000
 * Department: IT
 */
package N01_this;

public class S03_Employee {
	String name;
	int salary;
	String department;
	public void setSalary(int salary) {
		if(salary>=0)
			this.salary = salary;
		else
			System.out.println("연봉 음수 안됨!");
	}
	public int getSalary() {
		return salary;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	public void applyBonus(double percent) {
		salary += (int)(salary*percent/100);
//		setSalary((int)(salary*(100+percent)/100));
	}
	public void printInfo() {
		System.out.println("Name: " + name);
		System.out.println("Salary: $" + salary);
		System.out.println("Department: " + department);
	}
}
