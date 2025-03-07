package problem;

import java.util.Scanner;

public class Problem {
	static boolean[] visitCol;
	static boolean[] visitRUCross;
	static boolean[] visitRDCross;
	static int N;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			
			visitCol = new boolean[N];
			visitRUCross = new boolean[2*N];
			visitRDCross = new boolean[2*N];
			
			ans = 0;
			
			func(0);
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
	
	static void func(int row) {
		if (row == N) {
			++ans;
			return;
		}
		
		for (int col = 0; col < N; col++) {
			if(visitCol[col] || visitRUCross[row + col + 1] || visitRDCross[row - col + N])
				continue;
			
			visitCol[col] = true;
			visitRUCross[row + col + 1] = true;
			visitRDCross[row - col + N] = true;
			
			func(row + 1);
			
			visitCol[col] = false;
			visitRUCross[row + col + 1] = false;
			visitRDCross[row - col + N] = false;

		}
	}
}