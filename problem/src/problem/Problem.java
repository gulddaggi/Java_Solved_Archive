package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem {
	static int N;
	static int[][] board;
	static boolean[] valueCheck;
	static boolean[][] visit;
	static int ans;
	static int[] dRow = {-1, -1, 1, 1};
	static int[] dCol = {-1, 1, 1, -1};
	static int[] directionCheck;
	static int startRow;
	static int startCol;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int T = Integer.parseInt(st.nextToken());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					valueCheck = new boolean[101];
					visit = new boolean[N][N];
					directionCheck = new int[4];
										
					valueCheck[board[i][j]] = true;
					startRow = i;
					startCol = j;
					func(0, startRow, startCol, -1);
				}
			}
			
			sb.append("#" + testCase + " " + ans + "\n");
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
	
	static void func(int count, int row, int col, int direction) {
		if (startRow == row && startCol == col && count > 0) {
			ans = Math.max(ans, count);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nRow = row + dRow[i];
			int nCol = col + dCol[i];
			
			if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) {
				continue;
			}
			
			if (directionCheck[i] > 0) {
				if (direction != i) {
					continue;
				}
			}
			
			if (startRow == nRow && startCol == nCol) {
				if (count >= 3 && count > ans) {
					func(count + 1, nRow, nCol, i);
				}
			}
			else {
				int val = board[nRow][nCol];
				if (visit[nRow][nCol] || valueCheck[val]) {
					continue;
				}
				
				visit[nRow][nCol] = true;
				valueCheck[val] = true;
				++directionCheck[i];
				
				func(count + 1, nRow, nCol, i);
				
				visit[nRow][nCol] = false;
				valueCheck[val] = false;
				--directionCheck[i];
			}
			
		}
	}
}