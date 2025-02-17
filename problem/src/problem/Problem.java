package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		
		int[][] graph = new int[v+1][v+1];
		boolean[] isVisit = new boolean[v+1];
		
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int st = sc.nextInt();
			int en = sc.nextInt();
			
			graph[st][en] = 1;
			graph[en][st] = 1;			
		}
		
		Stack<Integer> st = new Stack<>();
		
		isVisit[1] = true;
		st.push(1);
		
		int ans = 0;
		while (!st.isEmpty()) {
			int cur = st.pop();
			
			for (int i = graph[cur].length-1; i >= 0; i--) {
				if (isVisit[i]) {
					continue;
				}
				
				if (graph[cur][i] == 1) {
					isVisit[i] = true;
					st.push(i);
					++ans;
				}
			}
		}
		
		System.out.println(ans);
	}
}