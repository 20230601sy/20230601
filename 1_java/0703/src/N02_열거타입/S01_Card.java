package N02_열거타입;

public class S01_Card {
	static final int CLOVER = 0;
	static final int HEART = 1;
	
	static final int TWO = 0;
	static final int THREE = 1;
	
	/*
	 * 원래 Enum은 class 나 Interface 만들 듯 따로 만들어서 관리한다심
	 * enum도 보통 class처럼 첫글자는 대문자로
	 */
	enum Kind { CLOVER, HEART };  
	enum Value { TWO, THREE };
}
