package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

class Fish{
	Pos pos;
	int size;
	boolean isDead;
	
	public Fish(Pos pos, int size) {
		this.pos = pos;
		this.size = size;
		isDead = false;
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
		boolean canEat = false;
		List<Fish> fishList = new ArrayList<>();
		
		Pos start = new Pos(0, 0);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ocean[i][j] = sc.nextInt();
				
				if (ocean[i][j] > 0) {
					if (ocean[i][j] == 9) {
						start = new Pos(i, j);
						ocean[i][j] = 0;
					}
					else {
						Fish fish = new Fish(new Pos(i, j), ocean[i][j]);
						fishList.add(fish);
						
						if (ocean[i][j] < size) {
							canEat = true;
						}
					}
				}
			}
		}
		
		Pos target = new Pos(0, 0);
		int targetIdx = 0;
		
		while (true) {
			canEat = false;
			for (int i = 0; i < fishList.size(); i++) {
				if (fishList.get(i).isDead || fishList.get(i).size >= size) {
					continue;
				}
				
				target.x = fishList.get(i).pos.x;
				target.y = fishList.get(i).pos.y;
				targetIdx = i;
				canEat = true;
			}
			
			if (!canEat) {
				System.out.println(ans);
				break;
			}
			
			int[][] temp = new int[N][N];
			
			Queue<Pos> q = new LinkedList<>();
			q.add(start);
			temp[start.x][start.y] = 1;

			while (!q.isEmpty()) {
				Pos cur = q.poll();
				
				if (cur.x == target.x && cur.y == target.y) {
					ans += (temp[cur.x][cur.y] - 1);
					
					--count;
					
					if (count == 0) {
						++size;
						count = size;
					}
					
					fishList.get(targetIdx).isDead = true;
					
					start.x = cur.x;
					start.y = cur.y;
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					
					if (ocean[nx][ny] > size) continue;

					if (temp[nx][ny] > 0) continue;
					
					temp[nx][ny] = temp[cur.x][cur.y] + 1;
					q.add(new Pos(nx, ny));
				}
			}
		}
	}
}