package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			List<Integer>[] graph = new ArrayList[N+1];
			
			for (int idx = 1; idx <= N; idx++) {
				graph[idx] = new ArrayList<>();
			}
			
			for (int j = 0; j < M; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			boolean[] visit = new boolean[N+1];
			visit[1] = true;
						
			int ans = 0;
			
			for (int v : graph[1]) {
				if (!visit[v]) {
					++ans;
				}
				
				visit[v] = true;
				
				for (int nxt : graph[v]) {
					if (!visit[nxt]) {
						++ans;
					}
					
					visit[nxt] = true;
				}
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
		
	}
}