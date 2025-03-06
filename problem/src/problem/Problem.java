package problem;

import java.util.Scanner;

public class Problem {
	static int[] A = new int[1000000];
	static int N = A.length;
	static int[] temp = new int[N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		mergeSort(0, N-1);
		System.out.println(A[500000]);
	}
	
	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start+end) / 2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			merge(start, mid, end);
		}
	}
	
	static void merge(int start, int mid, int end) {
		int L = start;
		int R = mid + 1;
		
		int idx = start;
		
		while (L <= mid && R <= end) {
			if (A[L] <= A[R]) {
				temp[idx++] = A[L++];
			}
			else {
				temp[idx++] = A[R++];
			}
		}
		
        if (L <= mid) {
        	for (int i = L; i <= mid; i++) {
            	temp[idx++] = A[i];
            }
        }
        else {
        	for (int i = R; i <= end; i++) {
            	temp[idx++] = A[i];
            }
        }
		
		for (int i = start; i <= end; i++) {
        	A[i] = temp[i];
        }
	}
}