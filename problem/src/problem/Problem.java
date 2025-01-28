package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int size = sc.nextInt();
			String str = sc.next();
			
			Stack<Integer> st1 = new Stack<>();
			Stack<Character> st2 = new Stack<>();
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '+' || c == '*' || c == '(' || c == ')') {
					if (st2.empty()) {
						st2.push(c);
						continue;
					}
					
					if (c == '*') {
						while (true) {
							if (st2.empty()) {
								st2.push(c);
								break;
							}
							
							if(st2.peek() == '*') {
								st2.pop();
								st1.push(st1.pop() * st1.pop());
							}
							else {
								st2.push(c);
								break;
							}
						}
					}
					else if (c == '+') {
						while (true) {
							if (st2.empty()) {
								st2.push(c);
								break;
							}
							
							if(st2.peek() == '*') {
								st2.pop();
								st1.push(st1.pop() * st1.pop());
							}
							else {
								st2.push(c);
								break;
							}
						}
					}
					else if (c == ')') {
						while(true) {
							if(st2.peek() == '(') {
								st2.pop();
								break;
							}
							else {
								if(st2.peek() == '+') {
									st2.pop();
									st1.push(st1.pop() + st1.pop());
								}
								else {
									st2.pop();
									st1.push(st1.pop() * st1.pop());
								}
							}
						}
					}
					else st2.push(c);
				}
				else st1.push((int)(c - '0'));
			}
			
			while (!st2.empty()) {
				if(st2.peek() == '+') st1.push(st1.pop() + st1.pop());
				else st1.push(st1.pop() * st1.pop());
	
				st2.pop();
			}
			
			System.out.println("#" + test_case + " " + st1.pop());
		}
	}

}
