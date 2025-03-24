package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Block{
	int m;
	List<Integer> idxList;
	
	public Block() {
		
	}
	
	public Block(int m) {
		this.m = m;
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
				
				fireBall.r = (fireBall.r + dRow[fireBall.d] * fireBall.s) % N;
				fireBall.c = (fireBall.r + dCol[fireBall.d] * fireBall.s) % N;
				
				
				if (board[fireBall.r][fireBall.c] == null) {
					board[fireBall.r][fireBall.c] = new Block(fireBall.m);
					board[fireBall.r][fireBall.c].idxList.add(i); 
					
				}
				else {
					board[fireBall.r][fireBall.c].m += fireBall.m;
					board[fireBall.r][fireBall.c].idxList.add(i);
					
					fireBallList.get(i).m = 0;
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
					
					
				}
			}
			
		}
		
		
		
	}
}