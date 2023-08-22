// 교재 207p 연습문제 6-1, 6-2, 6-3 (세트) 
package N04_생성자;

public class Test01_Student {
	String name;
	int ban, no, kor, eng, math;
	public Test01_Student() {
		
	}
	public Test01_Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String info() {
		int sum = kor + eng + math;
		double avg = Math.round(sum/3.0*10)/10.0;
		String str = name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + sum + "," + avg; 
		return str;
	}
	public int getTotal() {
		return kor + eng + math;
	}
	public float getAverage() {
		return (float) (Math.round(getTotal()/3.0*10)/10.0);
	}
}
