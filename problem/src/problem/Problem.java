package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		int d = sc.nextInt();
		
		w -= d*2;
		h -= d*2;
		
		if (w <= 0 || h <= 0) {
			System.out.println(0);
		}
		else {
			System.out.println(w * h);
		}
	}
}