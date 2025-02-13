package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {
			int K = sc.nextInt();
			
			Stack<Integer> st = new Stack<>();
			
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				
				if (num == 0) {
					st.pop();
				}
				else {
					st.push(num);
				}
			}
			
			int ans = 0;
			while (!st.empty()) {
				ans += st.pop();
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
