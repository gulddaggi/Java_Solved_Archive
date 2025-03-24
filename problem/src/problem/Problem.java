package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {
	static List<Integer>[] graph;
	static boolean[] visit;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			graph = new ArrayList[N+1];
			
			for (int idx = 1; idx <= N; idx++) {
				graph[idx] = new ArrayList<>();
			}
			
			for (int j = 0; j < M; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			ans = 0;
			visit = new boolean[N+1];
			
			dfs(1, 0);
			
			
			System.out.println("#" + testCase + " " + (ans-1));
		}
		
	}
	
	static void dfs(int v, int depth) {
		if (depth == 3) {
			return;
		}
		
		if (!visit[v]) {
			++ans;
		}
		
		visit[v] = true;
		
		for (int nxt : graph[v]) {
			if (nxt != 1) {
				dfs(nxt, depth + 1);
			}
		}
	}
}