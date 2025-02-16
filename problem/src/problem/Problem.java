package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			if (i <= 3) {
				arr[i] = i;
			}
			else {
				int val = arr[i-1];
				for (int j = 1; j < i; j++) {
					if (i % j == 0 && i / j >= j) {
						++val;
					}
				}
				
				arr[i] = val;
			}
		}
		
		System.out.println(arr[n]);
	}
}
