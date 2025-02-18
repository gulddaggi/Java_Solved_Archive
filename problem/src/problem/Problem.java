package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			Queue<String> forwardQ = new LinkedList<>();
			Queue<String> backwardQ = new LinkedList<>();
			
			int forwardCount = 0;
			int backwardCount = 0;
			if (N % 2 == 1) {
				forwardCount = N / 2 + 1;
			}
			else {
				forwardCount = N / 2;
			}
			
			backwardCount = N - forwardCount;
			
			for (int i = 0; i < forwardCount; i++) {
				forwardQ.add(sc.next());
			}
			
			for (int i = 0; i < backwardCount; i++) {
				backwardQ.add(sc.next());
			}
			
			System.out.print("#" + testCase + " ");
			
			while (!forwardQ.isEmpty() || !backwardQ.isEmpty()) {
				if (!forwardQ.isEmpty()) {
					System.out.print(forwardQ.poll() + " ");
				}
				
				if (!backwardQ.isEmpty()) {
					System.out.print(backwardQ.poll() + " ");
				}
			}
			
			System.out.println();
		}

	}
}