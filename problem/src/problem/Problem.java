package problem;

import java.util.Arrays;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int P = sc.nextInt();
			int[] arr = new int[P];
			for (int i = 0; i < P; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			int ans = (arr.length == 1) ? arr[0] * arr[0] : arr[0] * arr[P-1];
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
