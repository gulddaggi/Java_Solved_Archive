package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Glacier{
	int x;
	int y;
	int zeroCount;
	int height;
	boolean isVisit;
	
	public Glacier(int x, int y, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		zeroCount = 0;
		isVisit = false;
	}
}

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Glacier[][] ocean = new Glacier[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int height = sc.nextInt();
				ocean[i][j] = new Glacier(i, j, height);
				
				if (ocean[i][j].height <= 0) {
					ocean[i][j].isVisit = true;
				}
			}
		}
		
		int ans = 0;
		while (true) {
			int chunk = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {	
					ocean[i][j].isVisit = false;
					
					if (ocean[i][j].height > 0) {
						for (int dir = 0; dir < 4; dir++) {
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							
							if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
								continue;
							}
							
							if (ocean[nx][ny].height <= 0) {
								++ocean[i][j].zeroCount;
							}
						}
					}
					else {
						ocean[i][j].isVisit = true;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ocean[i][j].isVisit || ocean[i][j].height <= 0) {
						continue;
					}
					
					++chunk;
					ocean[i][j].isVisit = true;
					
					Queue<Glacier> q = new LinkedList<>();
					q.add(ocean[i][j]);
					
					while (!q.isEmpty()) {
						Glacier cur = q.poll();
												
						cur.height -= cur.zeroCount;
						cur.zeroCount = 0;
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							
							if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
								continue;
							}
							
							if (ocean[nx][ny].isVisit || ocean[nx][ny].height <= 0) {
								continue;
							}
							
							ocean[nx][ny].isVisit = true;
							q.add(ocean[nx][ny]);
						}
					}
				}
			}
			
			if (chunk >= 2) {
				System.out.println(ans);
				break;
			}
			else if (chunk == 0){
				System.out.println(0);
				break;
			}
			
			++ans;
		}
	}
}