package problem;

/*
 문제 : 2309 일곱 난쟁이
 시간 : 180ms
 풀이 : 두 명의 키 합이 (전체 합 - 100)인 경우를 이중 for문을 통해 탐색.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		
		// 입력과 동시에 전체 키를 합산
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		// 오름차순 출력을 위해 배열 정렬
		Arrays.sort(arr);
		
		// 빠른 break를 위해 label 사용
		find:
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i == j) continue; // 같은 인덱스인 경우 제외.
				
				if(arr[i] + arr[j] == total - 100) { // 두 명을 찾으면 해당 값을 0으로 변경
					arr[i] = 0;
					arr[j] = 0;
					
					break find;
				}
			}
		}
		
		// 값이 0인 경우를 제외하고 출력
		for (int i = 0; i < arr.length; i++) 
			if(arr[i] != 0) System.out.println(arr[i]);
	}
}
