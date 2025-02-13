package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			Stack<Character> st = new Stack<>();
			
			int num = sc.nextInt();
			String str = sc.next();
			
			int ans = 1;
			for (int i = 0; i < num; i++) {
				char c = str.charAt(i);
				
				// 여는 괄호 입력
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					st.push(c);
				}
				// 닫는 괄호 입력
				else {
					// 스택이 비어있는 경우 문자열 유효하지 않음
					if (st.empty()) {
						ans = 0;
					}
					
					// 각 괄호에 일치하는 여는 괄호가 스택 top에 위치하지 않을 경우 문자열 유효하지 않음 
					if (c == ')') {
						if (st.pop() != '(') ans = 0;
						
					}
					else if (c == ']') {
						if (st.pop() != '[') ans = 0;
					}
					else if (c == '}') {
						if (st.pop() != '{') ans = 0;
					}
					else {
						if (st.pop() != '<') ans = 0;
					}
				}
				
				if (ans == 0) break;
			}
			
			System.out.println("#" + testCase + " " + ans);
			
		}
	}
}
