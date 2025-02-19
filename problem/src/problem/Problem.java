package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			int mid = N / 2;
			int val = 0;
			int fac = 1;
			
			int ans = 0;
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				
				for (int j = 0; j < str.length(); j++) {
					if (j >= mid - val && j <= mid + val) {
						ans += (str.charAt(j) - '0');
					}
				}
				
				if (val == mid) {
					fac = -1;
				}
				
				val += fac;
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}