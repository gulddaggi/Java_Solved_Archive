package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem {
	static int N;
	static int ans;
	static int direction;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 중앙에서 시작
		int row = N / 2;
		int col = N / 2;
		
		// 왼쪽부터 이동
		int factor = -1;
		int count = 1;
		
		// 0 왼 1 아래 2 오 3 위
		direction = 0;
		ans = 0;
		
		tor:
		while (true) {
			for (int i = 0; i < count; i++) {
				if (row <= 0 && col <= 0) {
					break tor;
				}
				
				// 토네이도 이동
				col += factor;
								
				// 모래 이동
				moveSand(row, col);
			}
			
			direction = (direction + 1) % 4;
						
			factor *= -1;
			
			for (int i = 0; i < count; i++) {
				// 토네이도 이동
				row += factor;
				
				// 모래 이동
				moveSand(row, col);
			}
			
			direction = (direction + 1) % 4;
			
			++count;
		}
		
		System.out.println(ans);
	}
	
	static void moveSand(int curRow, int curCol) {		
		int remain = board[curRow][curCol];
		
		int[] dRow = new int[9];
		int[] dCol = new int[9];
		int[] percents = {10, 7, 2, 1, 10, 7, 2, 1, 5};
		
		if (board[curRow][curCol] == 0) {
			return;
		}
		
		// 왼쪽
		if (direction == 0) {
			dRow = new int[]{-1, -1, -2, -1, 1, 1, 2, 1, 0};
			dCol = new int[]{-1, 0, 0, 1, -1, 0, 0, 1, -2};
		}
		// 아래
		else if (direction == 1) {
			dRow = new int[]{1, 0, 0, -1, 1, 0, 0, -1, 2};
			dCol = new int[]{-1, -1, -2, -1, 1, 1, 2, 1, 0};
		}
		// 오른쪽
		else if (direction == 2) {
			dRow = new int[]{-1, -1, -2, -1, 1, 1, 2, 1, 0};
			dCol = new int[]{1, 0, 0, -1, 1, 0, 0, -1, 2};
		}
		// 위
		else {
			dRow = new int[]{-1, 0, 0, 1, -1, 0, 0, 1, -2};
			dCol = new int[]{-1, -1, -2, -1, 1, 1, 2, 1, 0};
		}
		
		// 계산
		for (int i = 0; i < percents.length; i++) {
			int nRow = curRow + dRow[i];
			int nCol = curCol + dCol[i];
			int val = (int)Math.floor(board[curRow][curCol] * percents[i] * 0.01);
			remain -= val;
			
			if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) {
				ans += val;
				continue;
			}
			
			board[nRow][nCol] += val;
		}
		
		// 남은 모래 a로 이동
		// 왼쪽
		if (direction == 0) {
			if (curCol - 1 < 0) {
				ans += remain;
			}
			else {
				board[curRow][curCol - 1] += remain;
			}
		}
		// 아래
		else if (direction == 1) {
			if (curRow + 1 >= N) {
				ans += remain;
			}
			else {
				board[curRow + 1][curCol] += remain;
			}
		}
		// 오른쪽
		else if (direction == 2) {
			if (curCol + 1 >= N) {
				ans += remain;
			}
			else {
				board[curRow][curCol + 1] += remain;
			}
		}
		// 위
		else {
			if (curRow - 1 < 0) {
				ans += remain;
			}
			else {
				board[curRow - 1][curCol] += remain;
			}
		}
		
		board[curRow][curCol] = 0;
	}
}