package problem;

/*
 문제 : 11725(트리의 부모 찾기)
 시간 : 1860ms
 풀이 : 트리의 루트 노드 1번에서부터 dfs를 수행하며 부모 노드를 갱신.
 현재 방문 노드가 아직 방문하지 않은 인접 노드를 순회할 때 해당 노드의 부모 노드를 현재 방문 노드임을 이용.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {
	// 인접 리스트로 트리 입력
	static List<List<Integer>> tree = new ArrayList<>();
	// 부모 노드 저장 배열
	static int[] ans;
	// 방문 여부 체크 배열
	static boolean isVisit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ans = new int[N+1];
		isVisit = new boolean[N+1];
		
		// 중첩 리스트 추가
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		// 트리 정보 입력
		for (int i = 0; i < N-1; i++) {
			int st = sc.nextInt();
			int en = sc.nextInt();
			
			// dfs 수행을 위해 양방향 입력
			tree.get(st).add(en);
			tree.get(en).add(st);
		}
		
		// 루트에서부터 dfs 수행하며 부모 노드 파악
		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
	
	static void dfs(int v) {
		isVisit[v] = true;
		
		for (int nxt : tree.get(v)) {
			// 노드를 방문하지 않았을 경우
			if (!isVisit[nxt]) {
				// 부모 노드  
				ans[nxt] = v;
				
				dfs(nxt);
			}
		}
	}
}