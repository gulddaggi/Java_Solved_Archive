package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		// 빠른 입력 사용.
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//
//		int N = Integer.parseInt(st.nextToken());
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Stack<Character> st = new Stack<>();
		boolean trigger = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '<') trigger = true;
			else if(c == '>') {
				System.out.print(c);
				trigger = false;
				continue;
			}
			
			if (trigger) {
				while (!st.empty()) System.out.print(st.pop());
				
				System.out.print(c);
			}
			else {
				if (c == ' ') {
					while (!st.empty()) System.out.print(st.pop());
					System.out.print(c);
					continue;
				}
				
				st.push(c);
			}
		}
		
		while (!st.empty()) System.out.print(st.pop());
	}
}
