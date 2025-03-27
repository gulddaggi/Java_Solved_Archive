package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos{
	int row;
	int col;
	
	public Pos() {
		
	}
	
	public Pos(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dRow = {0, -1, 0, 1};
		int[] dCol = {1, 0, -1, 0};
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[][] cheese = new int[N][N];
			
			for (int i = 0; i < cheese.length; i++) {
				for (int j = 0; j < cheese.length; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}
			
			int ans = 1;
			int count = N * N;
			for (int x = 1; x <= 100; x++) {
				if (count == 0) {
					break;
				}
				
				for (int i = 0; i < cheese.length; i++) {
					for (int j = 0; j < cheese.length; j++) {
						if (cheese[i][j] == x) {
							cheese[i][j] = -1;
							--count;
						}
					}
				}
				
				boolean[][] visit = new boolean[N][N];
				
				int chunk = 0;
				for (int i = 0; i < cheese.length; i++) {
					for (int j = 0; j < cheese.length; j++) {
						if (cheese[i][j] == -1 || visit[i][j]) {
							continue;
						}
						
						Queue<Pos> q = new LinkedList<>();
						q.add(new Pos(i, j));
						visit[i][j] = true;
						
						++chunk;
						
						while (!q.isEmpty()) {
							Pos cur = q.poll();
							
							for (int dir = 0; dir < 4; dir++) {
								int nRow = cur.row + dRow[dir];
								int nCol = cur.col + dCol[dir];
								
								if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) {
									continue;
								}
								
								if (cheese[nRow][nCol] == -1 || visit[nRow][nCol]) {
									continue;
								}
								
								visit[nRow][nCol] = true;
								q.add(new Pos(nRow, nCol));
							}
						}
					}
				}
				
				ans = Math.max(ans, chunk);
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
		
	}
}