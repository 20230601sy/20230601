/*
 * 별찍기랑 똑같은 방식으로 값 저장 후 출력
              1
           2  3
        4  5  6
     7  8  9 10
 11 12 13 14 15
 */
package N02_이차원배열;
public class Sample05 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int k = 1;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(i+j>=4) {
					arr[i][j] = k;
					System.out.printf("%3d", arr[i][j]);
					k++;
				}
				else
					System.out.print("   ");
			}
			System.out.println();
		}
		//////////////////////////////////////////////////
		k = 1;
		for(int i=0; i<arr.length; i++)
			for(int j=4-i; j<arr[i].length; j++)
				arr[i][j] = k++;
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(i+j>=4) // if(arr[i][j] == 0)
					System.out.printf("%3d", arr[i][j]);
				else
					System.out.print("   ");
			}
			System.out.println();
		}		
		// k 안 쓰면 식이 1+2+ ... + i 형태라 복잡해지네
		for(int i=0; i<arr.length; i++)
			for(int j=4-i; j<arr[i].length; j++)
				arr[i][j] = (i+1)*(i+2)/2+j-4;
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(i+j>=4) // if(arr[i][j] == 0)
					System.out.printf("%3d", arr[i][j]);
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
}
