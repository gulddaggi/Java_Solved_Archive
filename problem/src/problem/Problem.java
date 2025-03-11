package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String str = sc.next();
		String gori = new String("gori");
		
		boolean isGori = false;
		for (int i = 0; i < N-gori.length()+1; i++) {
			for (int j = 0; j < gori.length(); j++) {
				if (str.charAt(i+j) != gori.charAt(j)) {
					break;
				}
				
				if (j == gori.length()-1) {
					isGori = true;
				}
			}
		}
		
		if (isGori) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}