package N01_컬렉션;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class S02_Sample02 {	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=3; i++) {
			s.push(i);
			q.offer(i);
		}
		System.out.print("stack : ");
		while(!s.empty())
			System.out.print(s.pop() + " ");
		System.out.print("\nqueue : ");
		while(!q.isEmpty())
			System.out.print(q.poll() + " ");
	}
}
