package problem;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			System.out.print("#" + testCase + " ");
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
				return o2 - o1;
			});
			
			for (int i = 0; i < N; i++) {
				int order = sc.nextInt();
				
				// 삽입 연산
				if (order == 1) {
					int num = sc.nextInt();
					pq.add(num);
				}
				// 삭제 연산
				else {
					int num = pq.isEmpty() ? -1 : pq.poll();

					System.out.print(num + " ");
				}
			}
			
			System.out.println();
		}
	}
}