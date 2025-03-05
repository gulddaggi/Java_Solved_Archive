package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int thr = 1;
			
			for (int i = 0; i < N; i++) {
				thr = thr << 1;
			}
			
			--thr;
			
			System.out.print("#" + testCase + " ");
			
			if ((thr & M) == thr) System.out.println("ON");
			else System.out.println("OFF");
		}
	}
}