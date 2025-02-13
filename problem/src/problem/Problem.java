package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String str = sc.next();
			
			int stick = 0;
			int ans = 0;
			
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if (c == '(') {
					++stick;
				}
				else {
					// 레이저
					if (st.peek() == '(') { 
						--stick;
						ans += stick;
					}
					// 막대
					else {
						--stick;
						++ans;
					}
				}
				
				st.push(c);
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
