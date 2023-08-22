package N03_채팅클라이언트;

import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8888); // 지금은 자기 자신에 다시 연결하는 거라서 localhost, 원래는 서버 ip, port
//			Socket socket = new Socket("172.30.1.31", 8888); // 강사님 자리 ip ㄷㄷ
			System.out.println("서버와 연결 성공");
			
			ReceiveThread rt = new ReceiveThread(socket);
			SendThread st = new SendThread(socket);
			
			rt.start();
			st.start();
//			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
//			BufferedReader br = new BufferedReader(isr);
//			
//			String now = br.readLine();
//			br.close();
//			System.out.println("서버 시간 : " + now);
		} catch(Exception e) {
			
		}

	}

}
