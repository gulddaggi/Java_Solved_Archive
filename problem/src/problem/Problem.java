package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		game:
		for (int i = 0; i < N; i++) {
			int[] arrA = new int[4];
			int[] arrB = new int[4];
			
			int countA = sc.nextInt();
			for (int j = 0; j < countA; j++)
				++arrA[sc.nextInt()-1];
			
			int countB = sc.nextInt();
			for (int j = 0; j < countB; j++)
				++arrB[sc.nextInt()-1];
			
			for (int j = 3; j >= 0; j--) {
				if (arrA[j] > arrB[j]) {
					System.out.println("A");
					continue game;
				}
				else if (arrB[j] > arrA[j]) {
					System.out.println("B");
					continue game;
				}
			}
			
			System.out.println("D");
		}
	}
}
