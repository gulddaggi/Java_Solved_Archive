package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 입력 배열
			char[][] arr = new char[N][];
			// 각 줄마다 해당 색을 칠해야 하는 칸 수 저장 배열
			int[][] countArr = new int[N][3];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
								
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 'W') ++countArr[i][0];
					if (arr[i][j] != 'B') ++countArr[i][1];
					if (arr[i][j] != 'R') ++countArr[i][2];
				}
			}
			
			int ans = Integer.MAX_VALUE;
			
			// 각 영역을 확장하며 최소 색칠 횟수 판단
			// 흰색은 N-2줄까지 확장 가능
			for (int white = 0; white < N-2; white++) {
				// 파란색은 흰색 다음줄부터 N-1줄까지 확장 가능
				for (int blue = white + 1; blue < N-1; blue++) {
					int count = 0;
					
					// 흰색 색칠 횟수
					for (int i = 0; i <= white; i++) {
						count += countArr[i][0];
					}
					
					// 파란색 색칠 횟수
					for (int i = white + 1; i <= blue; i++) {
						count += countArr[i][1];
					}
					
					// 빨간색 색칠 횟수
					for (int i = blue + 1; i < N; i++) {
						count += countArr[i][2];
					}
					
					ans = Math.min(ans, count);
				}
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
