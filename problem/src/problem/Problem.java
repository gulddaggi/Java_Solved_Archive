package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		isVisit[1] = true;
		
		int ans = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			
			for (int i = 0; i < graph[cur].length; i++) {
				if (isVisit[i]) {
					continue;
				}
				
				if (graph[cur][i] == 1) {
					isVisit[i] = true;
					q.add(i);
					++ans;
				}
			}
		}
		
		System.out.println(ans);
		
	}
}