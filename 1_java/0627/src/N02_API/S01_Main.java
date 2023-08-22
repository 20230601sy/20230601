package N02_API;

public class S01_Main {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		System.out.println(str1 == str2); // true
		System.out.println(str1 == str3); // false
		System.out.println(str1.equals(str2)); // true
		System.out.println(str1.hashCode() == str2.hashCode()); // true 메모리 heap에 쌓아놓는 거라 중복저장하지 않음?? 자료구조를 공부하면 나오는 내용이라심. 기억 저편에 있는 hashtable... 
		
		// (1)
		StringBuffer sb = new StringBuffer();
		sb.append("hi");
		sb.append(" ");
		sb.append("java");
		
		// (2)
		String s = "";
		s += "hi";
		s += " ";
		s += "java";
		
		/*
		 * (1), (2)는 눈에 보이진 않지만 메모리 구조 자체에서 다른 점이 있음
		 * String은 연산할 때마다 매번 새로운 객체를 생성해서 작업 
		 * String은 불변 객체, 한 번 생성하면 못 바꾸기 때문에 String 클래스 
		 * 기본적으로 사용량은 StringBuffer가 메모리 사용량도 많고 속도도 느린 편이라서
		 * 일반적으로는 String 써서 그냥 한다심
		 * 문자열에 내용이 자주 변경된다하면 StringBuffer, 많이 변경되지 않으면 String쓴다심
		 * 지금 당장에는 String 쓰라심
		 */
		
		StringBuilder sbd = new StringBuilder();
		sb.append("hi");
		sb.append(" ");
		sb.append("java");
		// StringBuffer와 거의 비슷한 기능을 하는데, 쓰레드 배우면 차이가 조금 생긴다심. 걍 넘어감.
	}

}
