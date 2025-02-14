package problem;

import java.util.Scanner;

public class Problem {
	static int func(int num, int powNum) {
		if (powNum == 1) {
			return num;
		}
		
		return num * func(num, powNum-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();
			
			int num = sc.nextInt();
			int powNum = sc.nextInt();
			
			System.out.println("#" + T + " " + func(num, powNum));
			
		}

	}
}
