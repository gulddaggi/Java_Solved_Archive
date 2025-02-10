package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[100];
		for (int testCase = 1; testCase <= 10; testCase++) {
			int count = sc.nextInt();
			
			for (int i = 0; i < arr.length; i++) 
				arr[i] = sc.nextInt();
			
			int ans = 0;
			while (true) {
				// 가장 높은 상자, 가장 낮은 상자 인덱스 도출
				int minIdx = 0;
				int maxIdx = 0;
				for (int i = 1; i < arr.length; i++) {
					if (arr[i] < arr[minIdx]) {
						minIdx = i;
					}
					
					if (arr[i] > arr[maxIdx]) {
						maxIdx = i;
					}
				}
				
				// 최고점과 최저점의 차이 계산
				ans = arr[maxIdx] - arr[minIdx];
				if (ans <= 1 || count == 0) { // 평탄화 완료 or 제한된 횟수 수행 완료 시 수행 중지
					break;
				}
				else { // 덤프 수행
					--arr[maxIdx];
					++arr[minIdx];
				}
				
				count--;
			}
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
