package problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			
			Queue<String> password = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				
				password.add(str);
			}
			
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				String order = sc.next();
				
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				Queue<String> temp = new LinkedList<>();
				
				while (x-- != 0) {
					temp.add(password.poll());
				}
				
				for (int j = 0; j < y; j++) {
					String addStr = sc.next();
					
					temp.add(addStr);
				}
				
				while (!password.isEmpty()) {
					temp.add(password.poll());
				}
				
				password = temp;
			}
			
			System.out.print("#" + testCase + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(password.poll() + " ");
			}
			System.out.println();
		}
	}
}