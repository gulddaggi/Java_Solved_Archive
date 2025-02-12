package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			int T = sc.nextInt();
			
			String searchingStr = sc.next();
			String searchedStr = sc.next();
			
			int ans = 0;
			for (int j = 0; j < searchedStr.length() - searchingStr.length() + 1; j++) {
				++ans;
				for (int k = 0; k < searchingStr.length(); k++) {
					if (searchingStr.charAt(k) != searchedStr.charAt(j+k)) {
						--ans;
						break;
					}
				}
			}
			
			System.out.println("#" + T + " " + ans);
		}
	}
}
