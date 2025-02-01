package problem;

/*
 문제 : 1592(브론즈 2)
 시간 : 176ms
 풀이 : 원형임을 가정한 배열을 사용하여 공던지기를 수행. 인덱스 초과 시 원형 테이블 상 위치가 되도록 계산하여 반영.
 */

import java.util.Scanner;

public class Problem {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		//풀이
		// 자리 배열 선언
		int[] arr = new int[N];
		
		int idx = 0; // 현재 공을 받은 사람의 위치
		int ans = 0; // 공을 던진 총 횟수
		while (++arr[idx] < M) { // M번에 도달한 사람이 존재할 때까지 반복
			++ans; // 공 던지는 횟수 추가
			
			if (arr[idx] % 2 == 1) // 공을 받은 횟수가 홀수
				idx = (idx - L < 0) ? (idx - L + N) : (idx - L); // 인덱스 초과 시 N을 더해 반영
			else // 공을 받은 횟수가 짝수
				idx = (idx + L >= N) ? ((idx + L) % N) : (idx + L); // 인덱스 초과 시 N으로 나눈 나머지로 반영
		}
		
		System.out.println(ans);
	}
}
