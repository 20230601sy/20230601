package p02_chat.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatServer")
public class ChatServer {
	// 원래면 http://ip주소:포트번호/uri
	// 웹소켓은... ws://ip주소:포트번호(톰캣 8181)/uri 일단 ws로 시작하는 거가 다르다심!
	
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>()); // 클라이언트 여러 개 담을 수 있는 것에서 중복된 거 제거해주는 Set 사용, 이번에 session은 websocket import, 쓰레드 환경에서 안정하게 동기화되서 사용되도록 synchonizedSet 사용
	
	@OnOpen // 이 어노테이션 넣어두면 클라이언트가 저 /ChatingServer 주소로 접속했을 때 자동으로 이 메서드 실행시켜줌, 접속자의 정보가 session 매개변수로 들어옴...
	public void onOpen(Session session) { // 접속했을 때 실행할 메서드
		clients.add(session);
		System.out.println("웹 소켓 연결 : " + session.getId());
	}
	
	@OnMessage
	public void onMessage(String msg, Session session) throws IOException{
		System.out.println("메세지 전송 : " + session.getId() + " : " + msg);
		
		synchronized (clients) {
			for(Session client : clients) {
				if(!client.equals(session)) {
					client.getBasicRemote().sendText(msg);
				}
			}
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
		System.out.println("웹 소켓 종료 : " + session.getId());
	}
	
	@OnError
	public void onError(Throwable e) {
		System.out.println("오류 발생");
		e.printStackTrace();
	}
}