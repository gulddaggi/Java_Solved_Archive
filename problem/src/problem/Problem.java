package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem {
	static int N;
	static int M;
	static int D;
	static int ans = 0;
	static int board[][];
	static int[] dx = {0, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int total = 0;
	
	static Pos[] archers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		board = new int[N][M];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = sc.nextInt();
				
				if (board[i][j] == 1) {
					++total;
				}
			}
		}
		
		archers = new Pos[3];
		
		func(0, 0);
		
		System.out.println(ans);
	}
	
	static void func(int count, int idx) {
		if (count == 3) {
			ans = Math.max(ans, bfs());
			return;
		}
		
		for (int i = idx; i < M; i++) {
			archers[count] = new Pos(N, i);
			func(count + 1, idx + 1);
		}
	}
	
	static int bfs() {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tmp[i] = board[i].clone();
		}
		
		int count = 0;
		int totalCount = total;
		
		game:
		while (true) {
			if (totalCount == 0) {
				break game;
			}
			
			for (int i = 0; i < 3; i++) {
				Queue<Pos> q = new LinkedList<>();
				boolean[][] visit = new boolean[N][M];
				
				q.add(new Pos(archers[i].x - 1, archers[i].y));
				
				attack:
				while (!q.isEmpty()) {
					Pos cur = q.poll();
					
					for (int j = 0; j < dx.length; j++) {
						int nx = cur.x + dx[j];
						int ny = cur.y + dy[j];
						
						if (nx < 0 || ny < 0 || ny >= M) {
							continue;
						}
						
						if (visit[nx][ny] || Math.abs(archers[i].x - nx) + Math.abs(archers[i].y - ny) > D) {
							continue;
						}
						
						if (tmp[nx][ny] == 1 || tmp[nx][ny] == -1) {
							tmp[nx][ny] = -1;
							break attack;
						}
						
						visit[nx][ny] = true;
						q.add(new Pos(nx, ny));
					}
				}
			}
			
			// 적 1칸 아래로 이동
			for (int i = N-1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (tmp[i][j] == 1) {
						tmp[i][j] = 0;
						if (i+1 == N) {
							--totalCount;
							continue;
						}
						
						tmp[i+1][j] = 1;
					}
					else if (tmp[i][j] == -1) {
						tmp[i][j] = 0;
						--totalCount;
						++count;
					}
				}
			}
			
		}
		
		return count;
	}
}