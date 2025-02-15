package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String prob = sc.next();
		
		int N = prob.length();
		int R = 0;
		int C = 0;
		
		for (int i = 1; i <= N; i++) {
			if (N % i == 0 && N / i >= i) {
				R = i;
				C = N / i;
			}
		}
		
		
		char[][] arr = new char[R][C];
		
		int idx = 0;
		for (int dc = 0; dc < arr[0].length; dc++) {
			for (int dr = 0; dr < arr.length; dr++) {
				arr[dr][dc] = prob.charAt(idx++);
			}
		}
		
		for (int dr = 0; dr < arr.length; dr++) {
			for (int dc = 0; dc < arr[0].length; dc++) {
				System.out.print(arr[dr][dc]);
			}
		}
	}
}
