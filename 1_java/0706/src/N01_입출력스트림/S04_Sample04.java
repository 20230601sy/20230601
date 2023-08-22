/*
 * flush() 사용
 */
package N01_입출력스트림;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class S04_Sample04 {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("N01_입출력스트림_S04_Sample04.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos, 5); // 작업단위 5로 지정
		for(int i='1'; i<='9'; i++)
			bos.write(i);
		fos.close();
		// 결과 12345 저장됨...
		
		FileOutputStream fos1 = new FileOutputStream("N01_입출력스트림_S04_Sample04_1.txt");
		BufferedOutputStream bos1 = new BufferedOutputStream(fos1, 5); // 작업단위 5로 지정
		for(int i='1'; i<='9'; i++)
			bos1.write(i);
		bos1.flush(); // 보조스트림에 남아 있는 거 모조리!
		bos1.close();
		fos1.close();
		// 결과 123456789 저장됨!!!
		
		FileOutputStream fos2 = new FileOutputStream("N01_입출력스트림_S04_Sample04_2.txt");
		BufferedOutputStream bos2 = new BufferedOutputStream(fos2); // 작업단위 지정 안 함
		for(int i='1'; i<='9'; i++)
			bos2.write(i);
		bos2.flush(); // 보조스트림에 남아 있는 거 모조리!
		bos2.close();
		fos2.close();
		// 결과 123456789 저장됨!!!
	}

}
