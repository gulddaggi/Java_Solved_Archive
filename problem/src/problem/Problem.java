package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		int d = Math.min(H, W);
		
		System.out.println(d * 100 / 2);
	}
}