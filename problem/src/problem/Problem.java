package problem;

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	static int ans;
	static String S;
	static Stack<Character> st;
	static int idx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		S = sc.next();
		ans = 0;
		idx = 0;
		st = new Stack<>();
		
		ans += unZip(0);
		System.out.println(ans);
	}
	
	static int unZip(int k) {	
		int count = 0;
		
		while (idx < S.length()) {
			char cur = S.charAt(idx);
			
			// 여는 괄호
			if (cur == '(') {
				++count;
				
				// k가 숫자인경우
				if (idx - 1 >= 0 && Character.isDigit(S.charAt(idx-1))) {
					// 스택에 추가
					st.add(cur);
					// k 저장
					int tmp = S.charAt(idx-1) - '0';
										
					// 인덱스 이동
					++idx;
					// 압축 해제 수행
					count += unZip(tmp);
				}
			}
			// 닫는 괄호
			else if (cur == ')') {
				// 여는 괄호가 존재하면 압축 풀기
				if (!st.isEmpty()) {
					// 괄호 쌍 제거
					st.pop();
						
					// k와 여는괄호 계산 후 반환
					return (k * count - 2);
				}
				// 여는 괄호가 없으면 단일 카운팅
				else ++count;
			}
			// 숫자
			else ++count;
			
			// 인덱스 이동
			++idx;
		}
		
		// 압축 아닌경우
		return count;
	}
}