package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String str = sc.next();
			
			int val = 0;
			Stack<Character> opStack = new Stack<>();
			Stack<Integer> numStack = new Stack<>();
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				
				// 기호가 아닐 경우 숫자 변환
				if (c != '+') {
					if (val != 0) {
						val *= 10;
					}
					
					val += (c - '0');
				}
				// 기호일 경우 기호 스택에 저장
				else if(c == '+'){
					// 변환된 수를 수 스택에 저장
					numStack.push(val);
					val = 0;
					
					// 기호가 하나밖에 없으므로 스택이 빌때까지 연산 수행
					while (!opStack.empty()) {
						opStack.pop();
						
						numStack.push(numStack.pop() + numStack.pop());
					}
					
					// 연산 수행 이후 기호 push
					opStack.push(c);
				}
				
				// 문자열 끝에 도달한 경우
				if (i == N-1) {
					numStack.push(val);
					
					numStack.push(numStack.pop() + numStack.pop());
				}
			}
			
			System.out.println("#" + tc + " " + numStack.pop());
		}
	}
}
