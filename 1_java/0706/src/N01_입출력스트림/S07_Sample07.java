package N01_입출력스트림;

import java.io.BufferedReader;
import java.io.FileReader;

public class S07_Sample07 {

	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("src/N01_입출력스트림/S07_Sample07.java");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		int numLine=0;
		while((line = br.readLine())!=null) {
			numLine++;
			if(line.indexOf(";") != -1) // ; 이 있는 라인만 출력하게 조건을 걸어줌~
				System.out.println(numLine + " : " + line);
		}
		br.close();
		fr.close();
	}
}
/*
 * 서블릿할 때 좀 쓸텐데 편한 라이브러리를 이미 누군가 만들어놔서 갖다쓸거라심~
 */