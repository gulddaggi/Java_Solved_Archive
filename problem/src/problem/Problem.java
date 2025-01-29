package problem;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int Z = sc.nextInt();
			
			String A = "", B = "", C = "";
			String num = "1";
			for (int i = 0; i < X; i++) {
				A += num;
				B += num;
				
				num = (num.equals("1")) ? "0" : "1";
			}
			
			int bLen = B.length();
			for (int i = 0; i < Y; i++) {
				if(i+1 <= bLen) C += B.charAt(i);
				else {
					B += num;
					C += num;
					
					num = (num.equals("1")) ? "0" : "1";
				}
			}
						
			if(X < Z) {
				for (int i = 0; i < Z; i++) {
					A += num;
					C += num;
				}
			}

			System.out.println("#" + test_case + " " + A + " " + B + " " + C);
		}
	}
}
