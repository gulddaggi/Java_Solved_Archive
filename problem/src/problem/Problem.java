package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int ans = 1;
			int N = sc.nextInt();
			sc.nextLine();
			
			List<String[]> list = new ArrayList<String[]>();
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				String[] nums = str.split(" ");
				list.add(nums);
			}
			
			for (String[] strings : list) {				
				if (strings.length == 2) { // 리프노드일때
					if (isOperator(strings[1])) { // 기호일때 연산 불가
						ans = 0;
						break;
					}
				}
				else { // 리프노드가 아닐 때
					if (!isOperator(strings[1])) { // 기호가 아니면 연산 불가
						ans = 0;
						break;
					}					
				}
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
	
	static boolean isOperator(String str) {
		return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
	}
}
