package problem;

/*
 문제 : 2292
 시간 : 168ms
 풀이 : 중앙 1번 방에서부터 각 둘레 칸 수가 증가하는 규칙만큼 칸을 증가하고 전체 합산.
 입력이 전체 합산보다 작으면 증가한 규칙 idx를 출력.
 */

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int num = 1;
		int idx = 1;
		while(num < N) {
			num += (2 * idx + 1) * 2 + (idx-1) * 2; // 규칙 idx만큼 칸 합산
			++idx;
		}
		
		System.out.println(idx);
	}
}
