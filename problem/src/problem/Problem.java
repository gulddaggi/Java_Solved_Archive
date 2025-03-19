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
	static Fish[] fishes;
	
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Fish[][] ocean = new Fish[4][4];
		fishes = new Fish[17];
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				int number = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				
				Fish fish = new Fish(i, j, direction, number);
				fishes[number] = fish;
				
				ocean[i][j] = fish;
			}
		}
		
		
		ans = ocean[0][0].number;
		ocean[0][0].number = 0;
		
		func(ocean, new Shark());
	}
	
	// 재귀 함수. 현재 물고기들 정보 1차원 배열과 상어를 전달받음
	static void func(Fish[][] ocean, Shark shark) {
		// 1차원 배열 순회하며 2차원 배열 구성
		
		// 상어 배치 및 값 계산
		
		// 물고기 이동
		// 1차원 배열 순회하며 1번 물고기부터 존재하는 물고기에 대해 이동 수행
		// 이동 후 1, 2차원 배열 모두에 적용.
		// 2차원 배열은 다음 물고기 이동에 반영하기 위함
		
		
		// 모든 물고기 이동 완료 후, 2차원 배열 순회하며 새로운 1차원 배열 구성
		
		// 상어가 이동가능한 모든 경우에 대해 재귀함수 호출
		// 새로운 1차원 배열과 이동할 좌표값을 갖는 새로운 상어를 전달
	}
}