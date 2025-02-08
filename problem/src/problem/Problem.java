package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			
			char c = order.charAt(0);
			if (c == 'p') { // push, pop
				char c2 = order.charAt(1);
				
				if (c2 == 'u') { // push
					int val = sc.nextInt();
					st.push(val);
				}
				else { // pop
					if(st.empty()) System.out.println(-1);
					else System.out.println(st.pop());
				}
			}
			else if (c == 't') { // top
				if(st.empty()) System.out.println(-1);
				else System.out.println(st.peek());
			}
			else if (c == 's') { // size
				System.out.println(st.size());
			}
			else { // empty
				if(st.empty()) System.out.println(1);
				else System.out.println(0);
			}
		}
	}
}
