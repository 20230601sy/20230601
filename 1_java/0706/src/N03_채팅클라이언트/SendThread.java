package N03_채팅클라이언트;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	Socket socket;
	Scanner sc = new Scanner(System.in);

	public SendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String sendMsg;
			
			while(true) {
				System.out.print("클라이언트 : ");
				sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);
				dos.flush();
				
			}
		} catch (Exception e) {

		}
	}
}