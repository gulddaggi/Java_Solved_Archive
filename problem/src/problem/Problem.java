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
	double cost;
	int en;
	
	public Edge(){
		
	}
	
	public Edge(double cost, int en) {
		this.cost = cost;
		this.en = en;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.cost > o.cost) {
			return 1;
		}
		else if (this.cost < o.cost) {
			return -1;
		}
		else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Edge [cost=" + cost + ", en=" + en + "]";
	}
}

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
		
			int[][] islands = new int[N][2];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
			
				for (int j = 0; j < N; j++) {
					islands[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(st.nextToken());
			
			List<Edge>[] adj = new ArrayList[N];
			
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					double dist = Math.sqrt(Math.pow(Math.abs(islands[i][0] - islands[j][0]), 2) + Math.pow(Math.abs(islands[i][1] - islands[j][1]), 2));
					adj[i].add(new Edge(E * Math.pow(dist, 2), j));
					adj[j].add(new Edge(E * Math.pow(dist, 2), i));
				}
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(adj[0]);
			
			boolean[] visited = new boolean[N];
			visited[0] = true;
			
			double ans = 0;
			
			int edgeCount = 0;
			
			while (edgeCount < N-1) {
				Edge cur = pq.poll();
				
				if (visited[cur.en]) {
					continue;
				}
				
				ans += cur.cost;
				visited[cur.en] = true;
				++edgeCount;
				
				pq.addAll(adj[cur.en]);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + testCase + " " + Math.round(ans));
			
			bw.write(sb.toString() + "\n");
			bw.flush();
		}
		
		bw.close();
	}
}