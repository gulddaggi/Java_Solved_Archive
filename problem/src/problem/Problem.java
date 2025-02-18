package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int P = 100 - sc.nextInt();
		
		int[] coins = {25, 10, 5, 1};
		
		for (int i = 0; i < coins.length; i++) {
			System.out.print(P / coins[i] + " ");
			P %= coins[i];
		}
	}
}