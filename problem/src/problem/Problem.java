package problem;

import java.util.Scanner;

public class Problem {
	static int N, ans, total;
	static int[] weight;
	static int[] fac = new int[10];
	static int[] pow = new int[10];
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		fac[0] = 1;
		pow[0] = 1;
		for (int i = 1; i < 10; i++) {
			fac[i] = fac[i-1] * i;
			pow[i] = pow[i-1] * 2;
		}
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			
			weight = new int[N];
			visit = new boolean[N];
			total = 0;
			
			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
				total += weight[i];
			}
			
			ans = 0;
			func(0, 0, 0);
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
	
	static void func(int level, int left, int right) {
		if (total - left <= left) {
			ans += fac[N-level] * pow[N-level];
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visit[i]) {
				continue;
			}
			
			visit[i] = true;
			
			func(level + 1, left + weight[i], right);
			
			if (left >= right + weight[i]) {
				func(level + 1, left, right + weight[i]);
			}
			
			visit[i] = false;
		}
	}
}
