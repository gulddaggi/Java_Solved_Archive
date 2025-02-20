package problem;

import java.util.Scanner;

public class Problem {
	static int[][] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			
			tree = new int[N+1][3];
			
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String[] nums = sc.nextLine().split(" ");
				
				// 정점
				int p = Integer.parseInt(nums[0]);
				// 문자
				int val = nums[1].charAt(0);
				
				tree[p][0] = val;
				for (int j = 2; j < nums.length; j++) {
					tree[p][j-1] = Integer.parseInt(nums[j]);
				}
			}
			
			System.out.print("#" + testCase + " ");
			inOrder(1);
			System.out.println();
		}
	}
	
	static void inOrder(int v) {
		if (tree[v][1] != 0) inOrder(tree[v][1]);
		System.out.print((char)tree[v][0]);
		if (tree[v][2] != 0) inOrder(tree[v][2]);
	}
}