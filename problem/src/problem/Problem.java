package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] countArr = new int[N+M+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					++countArr[i+j];
				}
			}
			
			int maxVal = 0;
			for (int i = 2; i <= N+M; i++) {
				if (countArr[i] >= maxVal) {
					maxVal = countArr[i];
				}
			}
			
			System.out.print("#" + testCase + " ");
			for (int i = 2; i <= N+M; i++) {
				if (countArr[i] == maxVal) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}