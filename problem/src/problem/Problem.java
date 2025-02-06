package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] cake = new int[L+1];
		
		int maxValIdx = 0;
		int maxVal = 0;
		int maxRealCount = 0;
		int maxRealCountIdx = 0;
		for (int i = 1; i <= N; i++) {
			// 번호 입력
			int left = sc.nextInt();
			int right = sc.nextInt();
			
			// 최대 기댓값 판별
			int val = right - left + 1;
			if(val > maxVal) { // 최대 기댓값일시 값 및 방청객번호 갱신
				maxVal = val;
				maxValIdx = i;
			}
			
			// 최대 실제값 판별
			int realCount = 0;
			for (int j = left; j <= right; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					++realCount;
				}
			}
			
			if(realCount > maxRealCount) {
				maxRealCount = realCount;
				maxRealCountIdx = i;
			}
		}
		
		System.out.println(maxValIdx);
		System.out.println(maxRealCountIdx);
	}
}
