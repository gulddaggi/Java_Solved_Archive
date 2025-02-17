package problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] popularity = new int[N+1];
		int[][] graph = new int[N+1][N+1];
		
		int total = 0;
		for (int i = 1; i <= N; i++) {
			popularity[i] = sc.nextInt();
			total += popularity[i];
		}
		
		for (int i = 1; i <= N; i++) {
			int edgeCount = sc.nextInt();
			
			for (int j = 0; j < edgeCount; j++) {
				int num = sc.nextInt();
				graph[i][num] = 1;
			}
		}
		
		// 모두 탐색가능인지 체크
		// 최소값
		int ans = 10000;
		
		for (int i = 1; i <= N; i++) {
			System.out.println("-------" + i + "-------");
			boolean[] isVisit = new boolean[N+1];
			boolean[] inCycle = new boolean[N+1];
			int count = 0;
			
			// 선거구 구분 시작
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			isVisit[i] = true;
			
			int val = 0;
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				System.out.println("현재 노드 : " + cur);
				
				++count;
				inCycle[cur] = true;
				
				// 가능한 방법인지 체크
				// 선거구를 빼고 모두 탐색이 가능한지 체크
				int cycleCount = 0;
				
				boolean isCycle = false;
				for (int j = 1; j <= N; j++) {
					// 이미 선거구인 정점 제외
					if (inCycle[j]) {
						continue;
					}
					
					// 현재 사이클 판단 루프에서 방문 여부 파악
					boolean[] cycleIsVisit = new boolean[N+1];
					
					Queue<Integer> cycleQ = new LinkedList<>();
					cycleQ.add(j);
					cycleIsVisit[j] = true;
					
					// 방문하지 않은 노드 대상으로 bfs 수행
					while (!cycleQ.isEmpty()) {
						int curCycleNode = cycleQ.poll();
						
						// 사이클 정점 개수 증가
						++cycleCount;
						
						for (int k = 1; k <= N; k++) {
							// 이미 선거구인 정점
							if (inCycle[k]) {
								cycleIsVisit[k] = true;
								continue;
							}
							
							// 현재 사이클 판단 루프에서 방문한 정점
							if (cycleIsVisit[k]) {
								continue;
							}
							
							// 현재 정점에서 방문할 수 없는 정점
							if (graph[curCycleNode][k] != 1) {
								continue;
							}
							
							cycleQ.add(k);
							cycleIsVisit[k] = true;
						}
					}
					
					if (cycleCount == N - count) {
						isCycle = true;
						break;
					}
				}
				
				val += popularity[cur];

				// 가능한 방법인 경우
				if (isCycle) {
					System.out.println("이외 구역의 사이클 형성 가능");
					// 최소값 갱신
					
					ans = Math.min(ans, total - val);
				}
				else {
					System.out.println("사이클 형성 안됨");
				}
				
				// bfs 수행
				for (int j = 1; j <= N; j++) {
					System.out.println("v : " + j);
					
					if (isVisit[j]) {
						System.out.println("이미 방문");
						continue;
					}
					
					if (graph[cur][j] != 1) {
						System.out.println("연결 안됨");
						continue;
					}
					
					System.out.println(j + " 를 큐에 삽입");
					q.add(j);
					isVisit[j] = true;
				}
			}
			
			if (count != N) {
				System.out.println(-1);
				return;
			}
			else {
				System.out.println(ans);
			}
		}
		
		
	}
}