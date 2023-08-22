package N01_컬렉션;

import java.util.Stack;

public class S04_Sample04 {

	public static void main(String[] args) {
		
		String str;
		str = "[{(a+b";
		System.out.println(str + " : " + isBracket(str));
		str = "[{(a+b)";
		System.out.println(str + " : " + isBracket(str));
		str = "[{(a+b)}";
		System.out.println(str + " : " + isBracket(str));
		str = "[{(a+b)}]";
		System.out.println(str + " : " + isBracket(str));
		str = "{(a+b)}";
		System.out.println(str + " : " + isBracket(str));
		str = "(a+b)";
		System.out.println(str + " : " + isBracket(str));
		str = "[{a+b} + (b+c)]";
		System.out.println(str + " : " + isBracket(str));
		str = "[{(a+b)*(a-b)} + {(c+d)*(c-d)}]*2";
		System.out.println(str + " : " + isBracket(str));
	}
	public static boolean isBracket(String input) {
		Stack<Character> s = new Stack<>();
		for(int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);
			if(ch == '(' || ch == '{' || ch == '[' )
				s.push(ch);
			else if(ch == ')' || ch == '}' || ch == ']' ) {
				if(s.isEmpty())
					return false;
				char pop = s.pop();
				if(        (pop=='(' && ch != ')') 
						|| (pop=='{' && ch != '}')
						|| (pop=='[' && ch != ']'))
					return false;
			}
//			System.out.println(ch + "   " + s);
		}
		return s.isEmpty();
	}
}
