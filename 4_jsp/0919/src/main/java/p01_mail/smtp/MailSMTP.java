package p01_mail.smtp;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSMTP {
	Properties serverInfo; // 이메일 서버 설정 저장하는 객체 // 서버 정보 담아줄 객체 이건 java.util 하나 밖에 없음
	Authenticator auth; // 이메일 서버 인증 정보를 저장하는 객체 // 사용자 인증 정보 import javax.mail.Authenticator; 선택 주의	
	
	public MailSMTP() {
		serverInfo = System.getProperties();
		serverInfo.put("mail.smtp.starttls.enable", "true"); // tls를 사용하도록 설정 // key, value 로 put해서 서버 설정들 넣어줌...보안 연결(TLS) 필요 요거 충족시켜주는 거...
//		serverInfo.put("mail.smtp.host", "smtp.naver.com"); // naver smtp 서버 설정
		serverInfo.put("mail.smtp.host", "smtp.gmail.com");
		serverInfo.put("mail.smtp.auth", "true"); // smtp인증을 사용
		serverInfo.put("mail.smtp.port", "587"); // smtp port번호 설정 // naver에서 제공해주는 포트번호 사용하는 거임... // 여기까지가 기본적인 요건
		
		// 아래는 추가적인 프로토콜 문제가 발생하는 거 처리
//		serverInfo.put("mail.smtp.ssl.trust", "smtp.naver.com"); // naver서버 주소를 신뢰한다고 설정 // 신뢰하지 않는 주소는 차단시켜서 추가적으로 해주는 거...
		serverInfo.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		serverInfo.put("mail.smtp.socketFactory.fallback", "false"); // 소켓팩토리 사용 안함. 이거 안 막으면 전송이 안되더라 통신... 
		serverInfo.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 프로토콜 버전 설정
		
		auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() { // 사용자 메일, 비번을 받아서 인증 정보를 만듦.
//				return new PasswordAuthentication("230601sy@naver.com", "$FT*xAB@eYv.k"); // "네이버메일주소", "네이버 비밀번호"
				return new PasswordAuthentication("20230601sy@gmail.com", "ynmhigbezzlfaj");
			}
		};
	}
	public int sendMail(String to, String subject, String content) { // 메일 보내주는 메서드, 성공 실패 결과 리턴 
		int result = 0; // 메일 전송 결과를 저장하는 변수, 0은 메일 전송 실패, 1은 성공이라 합시다.
		Session session = Session.getInstance(serverInfo, auth); // 이메일 전송에 필요한 세선객체를 생성
		session.setDebug(true); // 디버그모드 사용 이건 콘솔창에 로그 보여주는 거라 전송에는 있어도 그만 없어도 그만인 코드....
		MimeMessage msg = new MimeMessage(session); // 메일 전송 메세지 객체를 생성
		
		try {
			msg.setFrom(new InternetAddress("20230601sy@gmail.com")); // 보내는 사람 설정
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 받는 사람 설정 TO는 받는 사람 CC 참조 BCC 숨은 참조, 얘는 set이 아니고 add 받는 사람 계속 추가하면 됨...
			msg.setSubject(subject); // 제목
			msg.setText(content); // 내용
			Transport.send(msg); // 전송
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
