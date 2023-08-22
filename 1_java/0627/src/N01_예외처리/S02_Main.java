package N01_예외처리;

public class S02_Main {

	public static void main(String[] args) {
		try{
			int age = -10;
			setAge(age);
		} catch (S02_CustomException e){
			e.printStackTrace();
			System.out.println("끝");
		}
	}
	
	public static void setAge (int age) throws S02_CustomException { // 그냥 Exception 써도 되긴 한다심
		if(age<0) // 이런 건 try catch로 처리하지 못함
			throw new S02_CustomException("나이는 음수 안됨");
	}

}
