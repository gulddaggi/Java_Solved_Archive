package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j == i) continue;
			
				for (int k = 0; k < arr.length; k++) {
					if (k == i || k == j) continue;
					
					int val = arr[i] + arr[j] + arr[k];
					
					if (val <= M) {
						ans = Math.max(val, ans);
					}
				}
			}
			
		}
		
		System.out.println(ans);
	}
}
