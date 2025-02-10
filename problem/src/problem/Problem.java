package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = new int[1000];
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			// 각 점수 등장 횟수 카운팅
			int[] scores = new int[101];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				++scores[arr[i]];
			}
			
			// 가장 많이 등장한 점수 도출
			int ans = 0;
			for (int i = 0; i < scores.length; i++) {
				if (scores[ans] <= scores[i]) 
					ans = i;
			}
			
			
			System.out.println("#" + N + " " + ans);
		}
	}
}
