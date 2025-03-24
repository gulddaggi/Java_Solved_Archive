package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark{
	int row;
	int col;
	int num;
	int direction;
	int[][] prior;
	
	public Shark() {
		
	}
	
	public Shark(int row, int col, int num, int direction, int[][] prior) {
		this.row = row;
		this.col = col;
		this.num = num;
		this.direction = direction;
		this.prior = prior;
	}
}

class Block{
	int row;
	int col;
	int count;
	int scent;
	int sharkNum;
	
	public Block() {
		
	}
	
	public Block(int row, int col, int count, int scent, int sharkNum) {
		this.row = row;
		this.col = col;
		this.count = count;
		this.scent = scent;
		this.sharkNum = sharkNum;
		
	}
}

public class Problem {
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 방향에 따른 이동 배열
		int[] dRow = {-1, 1, 0, 0};
		int[] dCol = {0, 0, -1, 1};
		
		Block[][] ocean = new Block[N][N];
		Shark[] sharks = new Shark[M+1];
		
		// 격자 입력
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				int val = Integer.parseInt(st.nextToken());
				
				ocean[row][col] = new Block(row, col, 0, 0, val);
				if (val != 0) {
					sharks[val] = new Shark(row, col, val, 0, new int[4][4]);
				}
			}
		}
		
		// 상어 방향 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			sharks[i].direction = Integer.parseInt(st.nextToken());
		}
		
		// 상어 방향 우선순위 배열 입력
		for (int i = 1; i <= M; i++) {
			for (int row = 0; row < 4; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < 4; col++) {
					sharks[i].prior[row][col] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// 상어 이동 시작
		int sharkCount = M;
		int time = 0;
		while (time <= 1000 && sharkCount != 1) {
			// 냄새 뿌려진 칸의 냄새 감소
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (ocean[row][col].count != 0) {
						--ocean[row][col].count;
						
						if (ocean[row][col].count == 0) {
							ocean[row][col].scent = 0;
						}
					}
				}
			}

			// 상어 위치에 냄새 뿌리기
			for (int i = 1; i <= M; i++) {
				Shark curShark = sharks[i];
				
				// 존재한 상어가 아닐 경우
				if (curShark.num == 0) continue;
				
				// 냄새 뿌리기
				ocean[curShark.row][curShark.col].scent = curShark.num;
				ocean[curShark.row][curShark.col].count = K;
			}
			
			// 이동
			for (int i = 1; i <= M; i++) {
				Shark curShark = sharks[i];
								
				// 존재한 상어가 아닐 경우
				if (curShark.num == 0) continue;
				
				// 현재 방향에서 방향 우선순위
				int[] directions = curShark.prior[curShark.direction-1];
				
				boolean isMove = false;
				// 우선순위 방향에 냄새가 없을 경우 이동
				for (int dir = 0; dir < directions.length; dir++) {
					int nRow = curShark.row + dRow[directions[dir]-1];
					int nCol = curShark.col + dCol[directions[dir]-1];
					
					if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) continue;
					
					// 이동 가능한 경우
					if (ocean[nRow][nCol].scent == 0) {
						// 상어가 겹친 경우
						if(ocean[nRow][nCol].sharkNum != 0) {							
							// 현재 상어 삭제
							if (ocean[nRow][nCol].sharkNum < curShark.num) {
								curShark.num = 0;
								ocean[curShark.row][curShark.col].sharkNum = 0;
								isMove = true;
								--sharkCount;
								break;
							}
							// 기존 상어 삭제
							else {
								sharks[ocean[nRow][nCol].sharkNum].num = 0;
								--sharkCount;
							}
						}
						
						// 이동 수행
						ocean[curShark.row][curShark.col].sharkNum = 0;
						
						ocean[nRow][nCol].sharkNum = curShark.num;
						
						sharks[i].direction = directions[dir];
						sharks[i].row = nRow;
						sharks[i].col = nCol;
						isMove = true;
						break;
					}
				}
				
				// 이동 못한 경우
				if (!isMove) {
					for (int dir = 0; dir < directions.length; dir++) {
						int nRow = curShark.row + dRow[directions[dir]-1];
						int nCol = curShark.col + dCol[directions[dir]-1];
						
						if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) continue;
						
						// 자기 냄새인 경우
						if (ocean[nRow][nCol].scent == curShark.num) {
							ocean[curShark.row][curShark.col].sharkNum = 0;
							
							ocean[nRow][nCol].sharkNum = curShark.num;
							
							sharks[i].direction = directions[dir];
							sharks[i].row = nRow;
							sharks[i].col = nCol;
							break;
						}
					}
				}
			}
			
			++time;
		}
		
		if (time > 1000) {
			System.out.println(-1);
		}
		else {
			System.out.println(time);
		}
	}
}