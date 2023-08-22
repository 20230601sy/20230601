package N03_오버로딩;

public class S01_CalcMain {

	public static void main(String[] args) {
		S01_Calc c = new S01_Calc();
		c.add(10, 20);
		c.addDouble(123.444, 555.33); // 이러면 귀찮다는 거!
		c.add(123.444, 555.33);
		// 오버로딩이 메서드 뿐만 아니라 뒤에 배울 생성자에서도 똑같다고 하심 ??? 으으으으으 
	}

}
