package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int testCase = 1; testCase <= 10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			sb.append("#" + testCase + " ");
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Integer>[] adj = new ArrayList[V+1];
			int[] indegree = new int[V+1];
			
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < E; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				adj[u].add(v);
				++indegree[v];
			}
			
			Queue<Integer> q = new LinkedList<>();
			List<Integer> order = new ArrayList<>();
			
			for (int i = 1; i <= V; i++) {
				if (indegree[i] == 0) {
					q.add(i);
					indegree[i] = -1;
				}
			}
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				sb.append(cur + " ");
				
				for (int v : adj[cur]) {
					--indegree[v];
					
					if (indegree[v] == 0) {
						q.add(v);
						--indegree[v];
					}
				}
			}
			
			bw.write(sb.toString() + "\n");
			bw.flush();
		}
		
		bw.close();
		
		
	}
}