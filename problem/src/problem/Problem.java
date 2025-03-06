package problem;

import java.util.Scanner;

public class Problem {
	static int[] A = new int[1000000];
	static int N = A.length;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		quickSort(0, N-1);
		
		System.out.println(A[500000]);
	}
	
	static void quickSort(int start, int end) {
		if (start < end) {
			int pivot = partition(start, end);
			quickSort(start, pivot - 1);
			quickSort(pivot+1, end);
		}
	}
	
	static int partition(int start, int end) {
		int pivot = A[start];
		
		int L = start + 1;
		int R = end;
		
		while (L <= R) {
			while (L <= R && A[L] <= pivot) {
				L++;
			}
			
			while (A[R] > pivot) {
				R--;
			}
			
			if (L < R) {
				int tmp = A[L];
				A[L] = A[R];
				A[R] = tmp;
			}
		}
		
		int tmp = A[start];
		A[start] = A[R];
		A[R] = tmp;
		
		return R;
	}
}