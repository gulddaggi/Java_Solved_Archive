package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String oct = sc.next();
		
		long dec = 0;
		int fac = 1;
		for (int i = oct.length()-1; i >= 0; i--) {
			dec += (oct.charAt(i) - '0') * fac;
			fac *= 8;
		}
		
		long bi = 0;
		String ans = "";
		while (dec != 0) {
			ans += Long.toString(dec % 2);
			dec /= 2;
		}
		
		for (int i = ans.length()-1; i >= 0; i--) {
			System.out.print(ans.charAt(i));
		}
	}
}
