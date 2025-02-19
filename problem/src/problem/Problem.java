package problem;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				list.addLast(sc.nextInt());
			}
			
			int M = sc.nextInt();
			
			while (M-- != 0) {
				String order = sc.next();
				
				if (order.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int i = 0; i < y; i++) {
						list.add(i+x, sc.nextInt());
					}
				}
				else if (order.equals("D")){
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int i = 0; i < y; i++) {
						list.remove(x);
					}
				}
				else {
					int y = sc.nextInt();
					
					for (int i = 0; i < y; i++) {
						list.addLast(sc.nextInt());
					}
				}
			}
			
			System.out.print("#" + testCase + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.pollFirst() + " ");
			}
			System.out.println();
		}
	}
}