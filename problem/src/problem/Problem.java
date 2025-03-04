package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pipe{
	int x;
	int y;
	int type;
	
	public Pipe(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] wall = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (wall[N-1][N-1] == 1) {
			System.out.println(0);
			return;
			
		}
		
		Queue<Pipe> q = new LinkedList<>();
		q.add(new Pipe(0, 1, 0));
		
		int ans = 0;
		while (!q.isEmpty()) {
			Pipe cur = q.poll();
			
			if (cur.x == N-1 && cur.y == N-1) {
				++ans;
				continue;
			}
			
			// 가로
			if (cur.type == 0) {
				// 가로 -> 가로
				int nx = cur.x;
				int ny = cur.y + 1;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (wall[nx][ny] != 1) {
						q.add(new Pipe(nx, ny, 0));
					}
				}
				
				// 가로 -> 대각선
				nx = cur.x + 1;
				ny = cur.y + 1;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (wall[nx][ny] != 1 && wall[nx-1][ny] != 1 && wall[nx][ny-1] != 1) {
						q.add(new Pipe(nx, ny, 1));
					}
				}
			}
			// 대각선
			else if (cur.type == 1) {
				// 대각선 -> 가로
				int nx = cur.x;
				int ny = cur.y + 1;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (wall[nx][ny] != 1) {
						q.add(new Pipe(nx, ny, 0));
					}
				}
				
				// 대각선 -> 대각선
				nx = cur.x + 1;
				ny = cur.y + 1;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (wall[nx][ny] != 1 && wall[nx-1][ny] != 1 && wall[nx][ny-1] != 1) {
						q.add(new Pipe(nx, ny, 1));
					}
				}
				
				// 대각선 -> 세로
				nx = cur.x + 1;
				ny = cur.y;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (wall[nx][ny] != 1) {
						q.add(new Pipe(nx, ny, 2));
					}
				}
			}
			// 세로
			else {
				// 세로 -> 세로
				int nx = cur.x + 1;
				int ny = cur.y;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (wall[nx][ny] != 1) {
						q.add(new Pipe(nx, ny, 2));
					}
				}
				
				// 세로 -> 대각선
				// 가로 -> 대각선
				nx = cur.x + 1;
				ny = cur.y + 1;
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (wall[nx][ny] != 1 && wall[nx-1][ny] != 1 && wall[nx][ny-1] != 1) {
						q.add(new Pipe(nx, ny, 1));
					}
				}
			}
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();		
	}
}