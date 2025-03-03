package problem;

import java.util.ArrayList;
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

public class Problem {
	static int N;
	static int M;
	static int[][] lab;
	static int ans = 0;
	static Pos[] walls = new Pos[3];
	static List<Pos> blankList;
	static List<Pos> virusList;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		lab = new int[N][M];
		blankList = new ArrayList<>();
		virusList = new ArrayList<>();
		
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[i].length; j++) {
				lab[i][j] = sc.nextInt();
				
				if (lab[i][j] == 2) {
					virusList.add(new Pos(i, j));
				}
				else if (lab[i][j] == 0) {
					blankList.add(new Pos(i, j));
				}
			}
		}
		
		func(0, 0);
		
		System.out.println(ans);
	}
	
	static void func(int depth, int idx) {
		if (depth == 3) {
			ans = Math.max(ans, bfs());
			
			return;
		}
		
		for (int i = idx; i < blankList.size(); i++) {
			walls[depth] = blankList.get(i);
			
			func(depth + 1, i + 1);
		}
	}
	
	static int bfs() {
		int[][] arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = lab[i].clone();
		}
		
		for (int i = 0; i < walls.length; i++) {
			arr[walls[i].x][walls[i].y] = 1;
		}
		
		Queue<Pos> q = new LinkedList<>();
		
		for (int i = 0; i < virusList.size(); i++) {
			q.add(virusList.get(i));
		}
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				if (arr[nx][ny] != 0) {
					continue;
				}
				
				arr[nx][ny] = 1;
				q.add(new Pos(nx, ny));
			}
		}
		
		int blanks = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					++blanks;
				}
			}
		}
		
		return blanks;
	}
}