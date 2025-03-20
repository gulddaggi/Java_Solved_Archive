package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Fish{
	int row;
	int col;
	int number;
	int direction;
	
	public Fish() {
		
	}
	
	public Fish(int row, int col, int number, int direction) {
		this.row = row;
		this.col = col;
		this.number = number;
		this.direction = direction;
	}
}

public class Problem {
	static int ans;
	static int[] dRow = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dCol = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Fish[] fishes = new Fish[17];
		
		int startNum = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				int number = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken())-1;
				
				Fish fish = new Fish(i, j, number, direction);
				fishes[number] = fish;
				
				if (i == 0 && j == 0) startNum = number;
			}
		}
		
		func(fishes, startNum, 0);
		System.out.println(ans);
	}
	
	// 재귀 함수. 현재 물고기들 정보 1차원 배열과 상어가 잡아먹을 물고기의 번호, 지금까지 잡아먹은 물고기 값의 합을 매개변수로
	static void func(Fish[] fishList, int sharkNum, int val) {		
		// 1차원 배열 순회하며 2차원 배열 구성
		Fish[] curFishes = new Fish[17];
		for (int i = 1; i <= 16; i++) curFishes[i] = new Fish(fishList[i].row, fishList[i].col, fishList[i].number, fishList[i].direction);
		
		Fish[][] ocean = new Fish[4][4];
		
		for (Fish fish : curFishes) {
			if (fish == null) continue;
			
			ocean[fish.row][fish.col] = fish;
		}
		
		// 상어 배치 및 값 계산
		Fish eatenFish = curFishes[sharkNum];
		
		int updatedVal = val + eatenFish.number;
		ans = Math.max(ans, updatedVal);
		
		eatenFish.number = 0;
		ocean[eatenFish.row][eatenFish.col].number = 0;
		
		// 물고기 이동
		// 1차원 배열 순회하며 1번 물고기부터 존재하는 물고기에 대해 이동 수행
		// 이동 후 1, 2차원 배열 모두에 적용.
		// 2차원 배열은 다음 물고기 이동에 반영하기 위함
		for (Fish fish : curFishes) {
			// 0 인덱스 패스
			if (fish == null) continue;
			
			// 빈 칸, 상어 칸 패스
			if (fish.number == 0 || fish.number == -1) continue;
			
			for (int i = 0; i <= 7; i++) {
				int dir = (fish.direction + i) % 8;

				int nRow = fish.row + dRow[dir];
				int nCol = fish.col + dCol[dir];
				
				// 범위 벗어난 경우 패스
				if (nRow < 0 || nRow >= 4 || nCol < 0 || nCol >= 4) continue;
				
				// 상어 칸 패스
				if (ocean[nRow][nCol].number == 0) continue;
				
				// 두 물고기 위치 교환 후 방향 갱신
				// 2차원 배열에서의 위치 갱신
				Fish targetFish = ocean[nRow][nCol];
				
				ocean[fish.row][fish.col] = targetFish;
				ocean[nRow][nCol] = fish;
				
				// 값 갱신
				targetFish.row = fish.row;
				targetFish.col = fish.col;
				
				fish.row = nRow;
				fish.col = nCol;
				fish.direction = dir;
				
				break;
			}
		}
		
		// 모든 물고기 이동 완료 후, 2차원 배열 순회하며 새로운 1차원 배열 구성
		for (int i = 0; i < ocean.length; i++) {
			for (int j = 0; j < ocean.length; j++) {
				int num = ocean[i][j].number;
				
				// 빈 칸 패스
				if (num == -1) continue;
				
				curFishes[num] = ocean[i][j];
			}
		}
		
		// 상어가 이동가능한 모든 경우에 대해 재귀함수 호출
		int dir = eatenFish.direction;
		for (int i = 1; i <= 3; i++) {
			int nRow = eatenFish.row + dRow[dir]*i;
			int nCol = eatenFish.col + dCol[dir]*i;
			
			// 범위 벗어난 경우 패스
			if (nRow < 0 || nRow >= 4 || nCol < 0 || nCol >= 4) continue;
			
			// 상어가 존재하는 경우 패스
			if (ocean[nRow][nCol].number == -1) continue;
			
			int target = ocean[nRow][nCol].number;
			
			// 상어 칸 빈 칸으로 변경
			curFishes[sharkNum].number = -1;
			
			// 새로운 1차원 배열과 이동할 좌표값을 갖는 새로운 상어를 전달
			func(curFishes, target, updatedVal);
		}
		
		return;
	}
}