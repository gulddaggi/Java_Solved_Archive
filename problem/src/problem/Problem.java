package problem;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int[] arr = new int[10];
		
		int val = A * B * C;
		
		while (val != 0) {
			int num = val % 10;
			++arr[num];
			val /= 10;
			System.out.println(val);
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
