package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	double cost;
	int st, en;
	
	public Edge(){
		
	}
	
	public Edge(double cost, int st, int en) {
		this.cost = cost;
		this.st = st;
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
		return "Edge [cost=" + cost + ", st=" + st + ", en=" + en + "]";
	}
	
	
}

public class Problem {
	static int[] p;
	static int[][] islands;
	static Edge[] edges;
	static double ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			islands = new int[N][2];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
			
				for (int j = 0; j < N; j++) {
					islands[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(st.nextToken());
			
			edges = new Edge[N*(N-1)/2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					double dist = Math.sqrt(Math.pow(Math.abs(islands[i][0] - islands[j][0]), 2) + Math.pow(Math.abs(islands[i][1] - islands[j][1]), 2));
					edges[idx++] = new Edge(dist, i, j);
				}
			}
			
			Arrays.sort(edges);
			ans = 0;
			
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = -1;
			}
			
			int edgeCount = 0;
			idx = 0;
			while (edgeCount < N-1) {
				Edge cur = edges[idx++];
				
				if (find(cur.st) != find(cur.en)) {
					union(cur.st, cur.en);
					ans += (E * Math.pow(cur.cost, 2));
					++edgeCount;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + testCase + " " + Math.round(ans));
			
			bw.write(sb.toString() + "\n");
			bw.flush();
		}
		
		bw.close();

		
	}
	
	static int find(int x) {
		if (p[x] < 0) {
			return x;
		}
		else {
			return p[x] = find(p[x]);
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) {
			return;
		}
		
		if (p[a] == p[b]) {
			--p[a];
		}
		
		if (p[a] < p[b]) {
			p[b] = a;
		}
		else {
			p[a] = b;
		}
	}
}