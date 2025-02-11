package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		for (int t = 0; t < 10; t++) {
			int N = sc.nextInt();
			
			int ans = 0;
			
			for (int i = 0; i < arr.length; i++) {
				int val = 0;
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
					
					val += arr[i][j];
				}
				
				ans = Math.max(ans, val);
			}
			
			for (int i = 0; i < arr.length; i++) {
				int val = 0;
				for (int j = 0; j < arr.length; j++) {
					val += arr[j][i];
				}
				
				ans = Math.max(ans, val);
			}
			
			int valCL = 0;
			int valCR = 0;
			for (int i = 0; i < arr.length; i++) {
				valCL += arr[i][i];
				valCR += arr[i][arr.length - i - 1];
			}
			
			ans = Math.max(ans, Math.max(valCL, valCR));
			System.out.println("#" + N + " " + ans);
		}
		
	}
}
