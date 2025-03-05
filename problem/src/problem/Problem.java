package problem;

import java.util.Scanner;

public class Problem {
	static int N;
	static int L;
	static int[][] info;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			info = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				info[i][0] = sc.nextInt();
				info[i][1] = sc.nextInt();
			}
			
			ans = 0;
			func(0, 0, 0);
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
	
	static void func(int idx, int cal, int score) {
		if (cal <= L) {
			ans = Math.max(ans, score);
		}
		
		if (idx >= N || cal > L) {
			return;
		}
		
		func(idx + 1, cal + info[idx][1], score + info[idx][0]);
		func(idx + 1, cal, score);
	}
}