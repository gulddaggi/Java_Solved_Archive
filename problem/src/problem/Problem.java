package problem;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int testCase = sc.nextInt();
			
			Queue<Integer> q = new LinkedList<>();
			
			for (int j = 0; j < 8; j++) {
				int num = sc.nextInt();
				
				q.add(num);
			}
			
			int val = 1;
			while (true) {
				int cur = q.poll();
								
				cur -= val;
				if (cur <= 0) {
					cur = 0;
					q.add(cur);
					break;
				}
				
				q.add(cur);
				++val;
				
				if (val == 6) {
					val = 1;
				}
			}
			
			System.out.print("#" + testCase + " ");
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			
			System.out.println();
		}
	}
}