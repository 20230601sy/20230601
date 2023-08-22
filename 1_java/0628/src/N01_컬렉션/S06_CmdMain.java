/*
 * Cmd 창에서 최근 사용 명령어 5개를 보여주는 프로그램
 */
package N01_컬렉션;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S06_CmdMain {
	static Queue<String> qCmds = new LinkedList<>();
	final static int MAX_SIZE = 5;
	
	static void save(String cmd) {
		qCmds.offer(cmd);
		if(qCmds.size() > MAX_SIZE)
			qCmds.poll();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		while(true) {
			System.out.print(">> ");
			String cmd = sc.nextLine().trim();
			save(cmd);
			if(cmd.equalsIgnoreCase("q"))
				System.exit(0); // 프로그램 강제 종료, break;
			else if(cmd.equalsIgnoreCase("help"))
				System.out.println("   help - 도움말을 보여줌\n"
						+ "   q 또는 Q - 프로그램 종료\n"
						+ "   history - 최근 입력한 명령어 " + MAX_SIZE + "개 보여줌");
			else if(cmd.equalsIgnoreCase("history")) {
				int cnt = 0;
				for(String q : qCmds)
					System.out.println("   " + (++cnt) + " : " + q);
			} else
				System.out.println(cmd + " 명령어가 실행되었습니다.");
		}
	}

}
