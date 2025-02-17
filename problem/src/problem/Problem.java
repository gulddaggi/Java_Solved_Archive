package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point{
	int x;
	int y;
	
	point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dx = {0, -1, 0, 1};
		int[] dy = {1, 0, -1, 0};
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			String str = sc.next();
			
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		Queue<point> q = new LinkedList<>();
		point start = new point(0, 0);

		q.add(start);
		
		while (!q.isEmpty()) {
			point cur = q.poll();
			
			if (cur.x == N-1 && cur.y == M-1) {
				System.out.println(arr[cur.x][cur.y]);
				break;
			}
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (arr[nx][ny] != 1) continue;
				
				q.add(new point(nx, ny));
				arr[nx][ny] = arr[cur.x][cur.y] + 1;
			}
		}
	}
}