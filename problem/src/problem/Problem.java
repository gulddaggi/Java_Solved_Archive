package problem;

import java.util.Scanner;

public class Problem {
	static int[][] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			
			sc.nextLine();
			
			tree = new int[N+1][3];
			for (int i = 0; i < N; i++) {
				String[] nums = sc.nextLine().split(" ");
				
				int v = Integer.parseInt(nums[0]);
				if (nums[1].equals("+") || nums[1].equals("-") || nums[1].equals("*") || nums[1].equals("/")) {
					tree[v][0] = -nums[1].charAt(0);
				}
				else {
					
					tree[v][0] = Integer.parseInt(nums[1]);
				}
				
				
				for (int j = 2; j < nums.length; j++) {
					tree[v][j-1] = Integer.parseInt(nums[j]);
				}
			}
			
			System.out.println("#" + testCase + " " + inOrder(1));
		}
	}
	
	static int inOrder(int v) {
		int left = 0;
		int val = 0;
		int right = 0;
		
		if (tree[v][1] != 0) left = inOrder(tree[v][1]);
		val = tree[v][0];
		if (tree[v][2] != 0) right = inOrder(tree[v][2]);
		
		if (val > 0) val = tree[v][0];
		else {
			val = -tree[v][0];
			
			if (val == '+') {
				val = left + right;
			}
			else if (val == '-') {
				val = left - right;
			}
			else if (val == '*') {
				val = left * right;
			}
			else {
				val = left / right;
			}
		}
		
		return val;
	}
}