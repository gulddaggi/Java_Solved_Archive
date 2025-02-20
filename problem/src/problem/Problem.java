package problem;

import java.util.Scanner;

public class Problem {
	static int[][] tree ;
	static int parent;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= 10; testCase++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int left = sc.nextInt();
			int right = sc.nextInt();
			
			tree = new int[V+1][2];
			
			for (int i = 0; i < E; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				
				if (tree[p][0] == 0) {
					tree[p][0] = c;
				}
				else {
					tree[p][1] = c;
				}
			}
			
			parent = 0;
			count = 0;
			findCo(1, left, right);
			counting(parent);
			
			System.out.println("#" + testCase + " " + parent + " " + count);
		}
	}
	
	static boolean findCo(int v, int left, int right) {
		if (v == 0) return false;
		
		if (v == left || v == right) return true;
		
		boolean leftCheck = findCo(tree[v][0], left, right);
		boolean rightCheck = findCo(tree[v][1], left, right);
		
		if (leftCheck && rightCheck) parent = v;

		return leftCheck || rightCheck;
	}
	
	static void counting(int v) {
		if (v == 0) return;
		
		++count;
		
		counting(tree[v][0]);
		counting(tree[v][1]);
	}
}