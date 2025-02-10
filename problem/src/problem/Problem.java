package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		int[] counts = new int[101];
		int[] countingArr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			++counts[arr[i]];
		}
		
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i-1];
		}
		
		for (int i = N-1; i >= 0; i--) {
			countingArr[--counts[arr[i]]] = arr[i];
		}
		
		System.out.println(countingArr[N / 2]);
	}
}
