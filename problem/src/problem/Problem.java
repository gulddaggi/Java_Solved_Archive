package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for (int i = 0; i < arr.length; i++) {
				if(N - i < M) break;
				for (int j = 0; j < arr.length; j++) {
					if(N - j < M) break;
					
					int val = 0;
					for (int dx = i; dx < i + M; dx++) {
						for (int dy = j; dy < j + M; dy++) {
							val += arr[dx][dy];
						}
					}
					ans = Math.max(ans, val);
				}
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
