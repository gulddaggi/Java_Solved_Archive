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

	@Override
	public String toString() {
		return "Edge [row=" + row + ", col=" + col + ", cost=" + cost + "]";
	}
}

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dRow = {0, -1, 0, 1};
		int[] dCol = {1, 0, -1, 0};

		int T = Integer.parseInt(st.nextToken());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] graph = new int[N][N];
			
			for (int i = 0; i < N; i++) {				
				String str = br.readLine();
				
				for (int j = 0; j < N; j++) {
					graph[i][j] = str.charAt(j) - '0';
				}
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			int[][] dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dist[0][0] = 0;
			pq.add(new Edge(0, 0, 0));
			
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				
				if (cur.row == N-1 && cur.col == N - 1) {
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
					
					if (dist[nRow][nCol] <= cur.cost + graph[nRow][nCol]) {
						continue;
					}
					
					dist[nRow][nCol] = cur.cost + graph[nRow][nCol];
					pq.add(new Edge(nRow, nCol, dist[nRow][nCol]));
				}
			}
			
			System.out.println("#" + testCase + " " + dist[N-1][N-1]);
		}
	}
}