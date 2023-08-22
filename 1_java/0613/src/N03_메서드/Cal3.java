/*
 * 계산기 정수 두개와 연산기호를 입력받아 두 정수를 연산한 결과를 출력
 * 정수 입력 : 5 10
 * 연산기호 입력 : +, -, *, /, %, 그외 입력은 잘못입력함 안내
 */
package N03_메서드;

public class Cal3 {
	public void showResult(int x, int y, char op) {
//		switch(op) {
//			case '+':
//				System.out.println(x + " + " + y + " = " + (x+y));
//				break;
//			case '-':
//				System.out.println(x + " - " + y + " = " + (x-y));
//				break;
//			case '*':
//				System.out.println(x + " * " + y + " = " + (x*y));
//				break;
//			case '/':
//				System.out.println(x + " / " + y + " = " + ((double)x/y));
//				break;
//			case '%':
//				System.out.println(x + " % " + y + " = " + (x%y));
//				break;
//			default :
//				System.out.println("Wrong Operator!");
//		}
		if(op=='+')
			System.out.println(x + " + " + y + " = " + (x+y));
		else if(op=='-')
			System.out.println(x + " - " + y + " = " + (x-y));
		else if(op=='*')
			System.out.println(x + " * " + y + " = " + (x*y));
		else if(op=='/')
			System.out.println(x + " / " + y + " = " + ((double)x/y));
		else if(op=='%')
			System.out.println(x + " % " + y + " = " + (x%y));
		else
			System.out.println("Wrong Operator!");
	}
}
