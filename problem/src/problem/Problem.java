package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos{
	int row;
	int col;
	
	public Pos(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int size = 2;
		int count = size;
		int ans = 0;
		
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, -1, 1, 0};
		
		int[][] ocean = new int[N][N];
		int[] fishes = new int[7];
		
		Pos start = new Pos(0, 0);
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				ocean[row][col] = sc.nextInt();
				
				if (ocean[row][col] > 0) {
					if (ocean[row][col] == 9) {
						start = new Pos(row, col);
						ocean[row][col] = 0;
					}
					else {
						++fishes[ocean[row][col]];
					}
				}
			}
		}
		
		boolean canEat = false;
		while (true) {
			Pos target = null;
			
			canEat = false;
			for (int i = 1; i < fishes.length; i++) {
				if (fishes[i] > 0 && i < size) {
					canEat = true;
				}
			}
			
			if (!canEat) {
				System.out.println(ans);
				break;
			}
			
			int[][] temp = new int[N][N];
			
			Queue<Pos> q = new LinkedList<>();
			q.add(start);
			temp[start.row][start.col] = 1;

			while (!q.isEmpty()) {
				Pos cur = q.poll();
				
				if (ocean[cur.row][cur.col] > 0 && ocean[cur.row][cur.col] < size) {					
					if (target == null) {
						target = cur;
					}
					else {
						int targetDist = temp[target.row][target.col];
						int curDist = temp[cur.row][cur.col];
						
						if (targetDist < curDist) {
							continue;
						}
						else {
							if (targetDist > curDist) {
								target = cur;
							}
							else {
								if (target.row == cur.row ) {
									if (target.col > cur.col) {
										target = cur;
									}
								}
								else if (target.row > cur.row) {
									target = cur;
								}
							}
						}
					}
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = cur.row + dx[i];
					int ny = cur.col + dy[i];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					
					if (ocean[nx][ny] > size) continue;

					if (temp[nx][ny] > 0) continue;
					
					temp[nx][ny] = temp[cur.row][cur.col] + 1;
					q.add(new Pos(nx, ny));
				}
			}
			
			if (target == null) {
				System.out.println(ans);
				break;
			}
			
			ans += (temp[target.row][target.col] - 1);
			
			--fishes[ocean[target.row][target.col]];
			ocean[target.row][target.col] = 0;
			
			--count;
		
			if (count == 0) {
				++size;
				count = size;
			}
			
			start.row = target.row;
			start.col = target.col;
		}
	}
}