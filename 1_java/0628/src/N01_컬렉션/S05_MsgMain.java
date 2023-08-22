/*
 * 예약메세지 전송
 * Queue를 활용하면 좋겠지~~~
 */
package N01_컬렉션;

import java.util.LinkedList;
import java.util.Queue;

public class S05_MsgMain {

	public static void main(String[] args) {
		Queue<Msg> m = new LinkedList<>();
		m.offer(new Msg("mail", "고길동"));
		m.offer(new Msg("sms", "둘리"));
		m.offer(new Msg("kakao", "도우너"));
		
		while(!m.isEmpty())
			System.out.println(m.poll());

	}

}

class Msg{
	String command;
	String to;
	
	public Msg(String command, String to) {
		this.command = command;
		this.to = to;
	}

	@Override
	public String toString() {
		return "Msg [command=" + command + ",	to=" + to + "]";
	}
}