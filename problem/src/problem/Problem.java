package problem;

/*
 문제 : 2477(참외밭)
 시간 : 176ms
 풀이 : 제일 큰 사각형넓이에서 밭이 아닌 넓이를 빼는 방식으로 접근.
 1. 입력 과정에서 최장 가로/세로 길이 값과 해당 값이 저장되는 인덱스를 찾고
 2. 최장 가로 길이 인덱스부터 배열을 돌며 밭이 아닌 부분의 넓이를 이루는 둘레 탐색.
 3. 입력 시 최장 가로 길이 다음 최장 세로 길이를 입력하지 않았다면,
 4가지 밭 모두 해당 인덱스로부터 각각 두번째, 세번째 다음으로 입력되었을 것이므로 두 값을 곱하여 빼야할 넓이를 계산.
  (ex 입력 순서 : 최장 가로 -> 세로1 -> 가로1 -> 세로2 -> 가로2 -> 최장 세로. 이때 가로1*세로2가 빼야할 넓이)
 4. 전체 넓이에서 계산된 넓이를 빼고, K를 곱해 정답을 도출하여 출력
 */

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int[][] arr = new int[6][2];
		
		int horMax = 0;
		int verMax = 0;
		int horMaxIdx = 0;
		int verMaxIdx = 0;
		for (int i = 0; i < arr.length; i++) { // 최장 가로/세로 길이와 이때의 인덱스 저장
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			
			if(arr[i][0] == 1 || arr[i][0] == 2) {
				if(horMax < arr[i][1]) {
					horMax = arr[i][1];
					horMaxIdx = i;
				}
			}
			else if(arr[i][0] == 3 || arr[i][0] == 4) {
				if(verMax < arr[i][1]) {
					verMax = arr[i][1];
					verMaxIdx = i;
				}
			}
		}
		
		int ans = 0;
		int idx = (horMaxIdx + 1) % 6; // 최장가로길이 다음 인덱스부터 탐색
		while(true) {
			if(idx != verMaxIdx) { // 해당 인덱스가 최장가로 혹은 세로 길이 다음일 경우
				// 전체 넓이 - 두번째와 세번째 변이 둘레인 사각형 넓이의 차를 계산
				ans = horMax * verMax - arr[(idx+1)%6][1] * arr[(idx+2)%6][1];
				break;
			}
			else idx = (idx + 1) % 6;
		}
		
		System.out.println(ans * K);
	}
}
