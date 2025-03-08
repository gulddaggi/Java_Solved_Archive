package problem;

/*
 문제 : 11057(오르막 수)
 시간 : 172ms
 풀이 : 자릿수가 증가할 때마다 발생하는 오르막 수에 해당하지 않는 수를 이전 개수에서 빼는 과정을 반복하여 개수를 구한다.
 
 ※ 본 풀이처럼 이전 값에서 규칙적인 값을 빼는 경우, 나머지 연산 과정으로 인해 값 누적 시 음수값이 갱신될 수 있음.
 이를 해결하기 위해 빼는 수에도 나머지연산 수(MOD) 만큼 값을 더해주어야 정상적인 결과가 출력됨.
 */

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
        int MOD = 10007;  // 모듈러 값 상수로 정의
		
        // 0번 인덱스 : 최종 값
        // 1~10번 인덱스 : 빼는 값
		long[][] dp = new long[1001][11];
		
		dp[1][0] = 10;
		dp[2][0] = 55;
		
		for (int i = 1; i <= 10; i++) dp[1][i] = i;
		
		for (int i = 3; i <= N; i++) {
			dp[i][0] = dp[i - 1][0];
			
			long val = 0;
			for (int j = 1; j <= 10; j++) {
				// 빼는 값 계산
				if (j == 1) dp[i-1][j] = (val + dp[i-2][0]) % MOD;
				else dp[i-1][j] = (val + dp[i-2][0] - dp[i-2][j-1] + MOD) % MOD; // 음수 방지 위해 +MOD 추가

				val = dp[i-1][j];
				
				// 값 누적
				dp[i][0] = (dp[i][0] + dp[i-1][0] - dp[i-1][j] + MOD) % MOD; // 음수 방지 위해 +MOD 추가
			}
		}
		
		dp[N][0] = dp[N][0] % MOD;
		
		System.out.println(dp[N][0] % 10007);
	}
}