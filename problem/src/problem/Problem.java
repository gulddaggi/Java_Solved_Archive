package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int row, col, cost;
	
	public Edge(int row, int col, int cost) {
		this.row = row;
		this.col = col;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Problem {
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dRow = {0, -1, 0, 1};
		int[] dCol = {1, 0, -1, 0};

		int idx = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}
			
			int[][] cave = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			int[][] dist = new int[N][N];
			
			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist.length; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			pq.add(new Edge(0, 0, cave[0][0]));
			dist[0][0] = cave[0][0];
			
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				
				if (cur.row == N-1 && cur.col == N-1) {
					break;
				}
				
				if (dist[cur.row][cur.col] != cur.cost) {
					continue;
				}
				
				for (int i = 0; i < 4; i++) {
					int nRow = cur.row + dRow[i];
					int nCol = cur.col + dCol[i];
					
					if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) {
						continue;
					}
					
					if (dist[nRow][nCol] <= cur.cost + cave[nRow][nCol]) {
						continue;
					}
					
					dist[nRow][nCol] = cur.cost + cave[nRow][nCol];
					pq.add(new Edge(nRow, nCol, dist[nRow][nCol]));
				}
			}
			
			System.out.println("Problem " + idx + ": " + dist[N-1][N-1]);
			
			++idx;
		}
	}
}