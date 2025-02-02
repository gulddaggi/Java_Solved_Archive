package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) 
			arr[i] = sc.nextInt();
		
		int ans = arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			if(Math.abs(ans + arr[i+1] - 100) <= Math.abs(ans - 100)) ans += arr[i+1];
			else break;
		}
		
		System.out.println(ans);
	}
}
