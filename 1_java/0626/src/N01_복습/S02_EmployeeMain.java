package N01_복습;

public class S02_EmployeeMain {

	public static void main(String[] args) {
//		S02_Management m = new S02_Management();
//		m.employees = new S02_Employee[3];
//		m.employees[0] = new S02_Manager("김점장", 150);
//		m.employees[1] = new S02_Engineer("이연구", 200);
//		m.employees[2] = new S02_SalesMan("나영업", 300);
//		for(int i=0; i<m.employees.length; i++)
//			System.out.println(m.employees[i]);

		S02_Management m = new S02_Management(10);
		m.addEmployee(new S02_Manager("김점장", 150));
		m.addEmployee(new S02_Engineer("이연구", 200));
		m.addEmployee(new S02_SalesMan("나영업", 300));
		m.info();
		m.totalBonus();
	}

}
