package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int v, cost;
	
	public Edge() {
		
	}
	
	public Edge(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", cost=" + cost + "]";
	}
	
	
}

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			List<Edge>[] adj = new ArrayList[N+1];
			
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int v = Integer.parseInt(st.nextToken());
					
					if (v != 0) {
						adj[i].add(new Edge(j, v));
					}
				}
			}
			
			int minVal = Integer.MAX_VALUE;
			
			for (int i = 1; i <= N; i++) {
				int[] dist = new int[N+1];
				for (int j = 1; j <= N; j++) {
					dist[j] = Integer.MAX_VALUE;
				}
				
				dist[i] = 0;
				PriorityQueue<Edge> pq = new PriorityQueue<>();
				
				pq.add(new Edge(i, dist[i]));
								
				while (!pq.isEmpty()) {
					Edge cur = pq.poll();
					
					if (dist[cur.v] != cur.cost) {
						continue;
					}
					
					for (Edge nxt : adj[cur.v]) {
						if (dist[nxt.v] <= dist[cur.v] + nxt.cost) {
							continue;
						}

						
						dist[nxt.v] = dist[cur.v] + nxt.cost;
						pq.add(new Edge(nxt.v, dist[nxt.v]));
					}
				}
				
				int val = 0;
				for (int j = 1; j <= N; j++) {
					val += dist[j];
				}
				
				minVal = Math.min(minVal, val);
			}
			
			sb.append("#" + testCase + " " + minVal + "\n");
			bw.write(sb.toString());
			bw.flush();
		}
		
		bw.close();
		
	}
}