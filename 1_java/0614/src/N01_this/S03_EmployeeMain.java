package N01_this;

public class S03_EmployeeMain {

	public static void main(String[] args) {
		S03_Employee employee = new S03_Employee();
		employee.name = "John Doe";
		employee.setSalary(50000);
		employee.setDepartment("IT");
		employee.applyBonus(10);
		employee.printInfo();
	}
}
