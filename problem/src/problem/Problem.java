package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] changes = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			System.out.println("#" + testCase);
			
			for (int i = 0; i < changes.length; i++) {
				int price = changes[i];
				
				System.out.print((N / price) + " ");
				
				if (N / price > 0) {
					N %= price;
				}
			}
			
			System.out.println();
		}
	}
}