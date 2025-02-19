package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 1; i < arr.length; i++) {
				int key = arr[i];
				
				int idx = i-1;
				while (idx >= 0 && key < arr[idx]) {
					arr[idx+1] = arr[idx];
					
					idx--;
				}
				
				arr[idx+1] = key;
			}
			
			System.out.print("#" + testCase + " ");
			
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			
			System.out.println();
		}
	}
}