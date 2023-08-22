package 게임;

import java.util.Arrays;

public class EnemyMap {
	int[][] isEnemy = new int[5][5]; 		// 적이 있으면 1로 만들고, 없으면 초기값 0
	Character[][] enemys; 	// isEnemy가 1이면 직업을 랜덤하게 캐릭터를 생성
	int numEnemy; 			// 현재 적의 수를 나타내는 변수, 해당 변수는 현재 사용하지는 않았지만 나중에 적의 수를 나타내주면 좋을 것 같아서 만들어둠
	
	public EnemyMap() { 	// 5-by-5에 랜덤하게 적을 분포시키는 메서드, 랜덤함수를 사용하여 0.1보다 작으면 적을 생성
//		isEnemy = new int[5][5]; 		// 배열 크기 설정, 5-by-5로 초기 설정
		enemys = new Character[5][5];   // 배열 크기 설정, 5-by-5로 초기 설정
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(Math.random() < 0.1) { // 10% 정도 확률로 적이 출현하도록 0.1 지정
					// if((int)(Math.random*10) == 0) 로 해도 10%
					isEnemy[i][j] = 1;
					enemys[i][j] = new Character((int)(Math.random()*5)+1); // 직업 1~5를 선택하여 캐릭터를 생성
					numEnemy++;
				}
			}
		}
	}
	public void showEnemyMap() { // 적의 위치를 출력해주는 메서드, 테스트를 위한 히든 메뉴
		System.out.println(Arrays.deepToString(isEnemy));
	}
}
