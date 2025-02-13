package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String str = sc.next();
		
		int holder = 0;
		boolean couple = false;
		for (int i = 0; i < N; i++) {
			char c = str.charAt(i);
			
			if (c == 'S') {
				if (i == N-1) {
					holder += 2;
				}
				else {
					++holder;
				}
			}
			else {
				if (couple) {
					couple = false;
					
					if (i == N-1) {
						++holder;
					}
				}
				else {
					couple = true;
					++holder;
				}
			}
		}
		
		if (holder >= N) {
			System.out.println(N);
		}
		else {
			System.out.println(holder);
		}
	}
}
