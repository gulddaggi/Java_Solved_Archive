package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int st, en, depth;
	
	public Edge() {
		
	}
	
	public Edge(int st, int en) {
		this.st = st;
		this.en = en;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.depth == o.depth) {
			return this.en - o.en;
		}
		
		return this.depth - o.depth;
	}

	@Override
	public String toString() {
		return "Edge [st=" + st + ", en=" + en + "depth=" + depth + "]";
	}
}

public class Problem {
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			List<Edge>[] list = new ArrayList[101];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			for (int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				int en = Integer.parseInt(st.nextToken());
				
				Edge edge = new Edge(idx, en);
				
				list[idx].add(edge);
			}
			
			boolean[] visited = new boolean[101];
			visited[start] = true;
			
			for (int i = 0; i < list[start].size(); i++) {
				list[start].get(i).depth = 0;
				pq.add(list[start].get(i));
			}
			
			Edge last = null;
			int edgeCount = 0;
			
			while (edgeCount < N && !pq.isEmpty()) {
				Edge cur = pq.poll();
			
				if (visited[cur.en]) continue;
				
				
				if (last == null) last = cur;
				else {
					if (last.depth < cur.depth) last = cur;
					else if (last.depth == cur.depth && last.en < cur.en) last = cur;
				}
				
				visited[cur.en] = true;
				++edgeCount;
				
				for (int i = 0; i < list[cur.en].size(); i++) {
					list[cur.en].get(i).depth = cur.depth + 1;
					pq.add(list[cur.en].get(i));
				}
			}
			
			System.out.println("#" + testCase + " " + last.en);
		}
	}
}