package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			
			String str = sc.next();
			
			Stack<Integer> numStack = new Stack<>();
			Stack<Character> opStack = new Stack<>();
			
			int val = 0;
			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);
				
				// 문자가 기호일 경우
				if (c == '+' || c == '*' || c == '(' || c == ')') {										
					// 연산자 스택이 비어있으면 바로 push
					if (opStack.empty()) {
						opStack.push(c);
					}
					else {
						// + 는 top이 +, *인 경우 연산 수행
						if (c == '+') {
							if (opStack.peek() != '(') {
								char op = opStack.pop();
								
								if (op == '+') {
									numStack.push(numStack.pop() + numStack.pop());
								}
								else {
									numStack.push(numStack.pop() * numStack.pop());
								}
							}

							opStack.push(c);
						}
						// *는 top이 *인 경우 연산 수행
						else if (c == '*') {
							if (opStack.peek() == '*') {
								opStack.pop();
								numStack.push(numStack.pop() * numStack.pop());
							}
							
							opStack.push(c);
						}
						// 닫힌괄호는 열린 괄호가 나올때까지 연산 수행
						else if (c == ')') {
							while (true) {
								char op = opStack.pop();
								
								if (op == '(') {
									break;
								}
								else {
									if (op == '+') {
										numStack.push(numStack.pop() + numStack.pop());
									}
									else {
										numStack.push(numStack.pop() * numStack.pop());
									}
								}
							}
						}
						// 열린 괄호는 바로 push
						else {
							opStack.push(c);
						}
					}
				}
				//문자가 숫자일 경우
				else {
					// 슷자로 변환
					if (val != 0) {
						val *= 10;
					}
					
					val += c - '0';
					
					// 다음 문자가 기호이거나 마지막 인덱스인 경우 숫자 push
					if (i == n-1 || (str.charAt(i + 1) < '0' || str.charAt(i + 1) > '9')) {
						numStack.push(val);
						val = 0;
					}
				}
			}
			
			
			// 남아있는 연산 수행
			while (!opStack.empty()) {
				char op = opStack.pop();
				
				if (op == '+') {
					numStack.push(numStack.pop() + numStack.pop());
				}
				else {
					numStack.push(numStack.pop() * numStack.pop());
				}
			}
			
			System.out.println("#" + tc + " " + numStack.pop());
		}
	}
}
