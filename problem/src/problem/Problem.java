package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int num = 1;
			int r = 0;
			int c = -1;
			int dir = 1;
			
			while (true) {
				for (int i = 0; i < N; i++) { // 수평 이동
					c += dir;
					arr[r][c] = num++;
				}
				
				--N;
				
				if (N == 0) {
					break;
				}
				
				for (int i = 0; i < N; i++) { // 수직 이동
					r += dir;
					arr[r][c] = num++;
				}
				
				dir *= -1;
			}
			
			System.out.println("#" + testCase);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
