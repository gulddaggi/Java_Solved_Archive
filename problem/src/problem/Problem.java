package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String str = sc.next();
			
			int left = 0;
			int right = str.length() - 1;
			
			int ans = 1;
			while (left < right) {
				if (str.charAt(left++) != str.charAt(right--)) {
                    ans = 0;
                    break;
                }				
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
