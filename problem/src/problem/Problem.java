package problem;

import java.util.Arrays;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int val = 2000000001;
		int leftVal = 0;
		int rightVal = 0;
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			int sum = Math.abs(arr[left] + arr[right]);
			System.out.println(arr[left] + " / " + arr[right]);
			
			// 기준 값보다 작다면 기준 값 갱신
			if (sum <= val) {
				leftVal = arr[left];
				rightVal = arr[right];
				
				if (sum == 0) {
					break;
				}
				
				val = sum;
			}
			
			// 좀 더 작은 합 도출해보기
			// 부호가 달라지면 더 작아질 가능성 없음
			if (arr[right] / Math.abs(arr[right]) != arr[mid] / Math.abs(arr[mid])) {
				left = mid;
			}
			// 부호가 같으면 더 작아질 가능성 있음
			else {
				right = mid;
			}
			
//			// 부호가 달라지면 더 작아질 가능성 없음
//			if (arr[right] / Math.abs(arr[right]) != arr[right - 1] / Math.abs(arr[right - 1])) {
//				++left;
//				right = arr.length - 1;
//			}
//			// 부호가 같으면 더 작아질 가능성 있음
//			else {
//				--right;
//			}
//			
//			else if (sum > val) {
//				++left;
//				right = arr.length - 1;
//			}
		}
		
		System.out.println(leftVal + " " + rightVal);
	}
}
