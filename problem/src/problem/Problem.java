package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String str = sc.nextLine();
			if (str.equals("#")) {
				break;
			}
			
			int ans = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					continue;
				}
				
				ans += (i+1) * (str.charAt(i) - 'A' + 1);
			}
			
			System.out.println(ans);
		}
	}
}