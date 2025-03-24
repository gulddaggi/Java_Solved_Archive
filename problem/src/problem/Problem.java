package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Block{
	int m;
	int s;
	int d;
	boolean isSame;
	List<Integer> idxList;
	
	public Block() {
		
	}
	
	public Block(int m, int s, int d) {
		this.m = m;
		this.s = s;
		this.d = d;
		isSame = true;
		idxList = new ArrayList<>();
	}
}

class FireBall{
	int r;
	int c;
	int m;
	int s;
	int d;
	
	public FireBall() {
		
	}
	
	public FireBall(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}

public class Problem {
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<FireBall> fireBallList = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			fireBallList.add(new FireBall(r, c, m, s, d));
		}
		
		int[] dRow = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dCol = {0, 1, 1, 1, 0, -1, -1, -1};
		
		for (int t = 0; t < K; t++) {
			// 2차원 배열
			Block[][] board = new Block[N][N];
			
			// 이동
			for (int i = 0; i < fireBallList.size(); i++) {
				FireBall fireBall = fireBallList.get(i);
				if (fireBall.m == 0) {
					continue;
				}
				
				// 이동 위치 계산
				fireBall.r = fireBall.r + (dRow[fireBall.d] * fireBall.s) % N;
				fireBall.c = fireBall.c + (dCol[fireBall.d] * fireBall.s) % N;
				
				// 범위 초과 고려
				if (fireBall.r >= N) {
					fireBall.r %= N;
				}
				else if (fireBall.r < 0) {
					fireBall.r = N + fireBall.r;
				}
				
				if (fireBall.c >= N) {
					fireBall.c %= N;
				}
				else if (fireBall.c < 0) {
					fireBall.c = N + fireBall.c;
				}
				
				// 중복 위치 체크
				if (board[fireBall.r][fireBall.c] == null) {
					board[fireBall.r][fireBall.c] = new Block(fireBall.m, fireBall.s, fireBall.d % 2);
					board[fireBall.r][fireBall.c].idxList.add(i); 
				}
				else {
					board[fireBall.r][fireBall.c].m += fireBall.m;
					board[fireBall.r][fireBall.c].s += fireBall.s;
					if (board[fireBall.r][fireBall.c].d != fireBall.d % 2)
						board[fireBall.r][fireBall.c].isSame = false;
					board[fireBall.r][fireBall.c].idxList.add(i);
				}
			}
			
			// 2개 이상의 파이어볼
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (board[row][col] == null) {
						continue;
					}
					
					if (board[row][col].idxList.size() == 1) {
						continue;
					}
					
					// 2개 이상의 파이어볼 처리
					// 무게 초기화
					for (int i = 0; i < board[row][col].idxList.size(); i++) {
						fireBallList.get(board[row][col].idxList.get(i)).m = 0;
					}
					
					int splitM = board[row][col].m / 5;
					int splitS = board[row][col].s / board[row][col].idxList.size();
					int dir = board[row][col].isSame ? 0 : 1;

					for (int i = 0; i < 4; i++) {
						if (splitM == 0) {
							continue;
						}
						fireBallList.add(new FireBall(row, col, splitM, splitS, dir));
						dir += 2;
					}
				}
			}
			
		}
		
		int ans = 0;
		for (FireBall fireBall : fireBallList) {
			ans += fireBall.m;
		}
		
		System.out.println(ans);
		
		
	}
}