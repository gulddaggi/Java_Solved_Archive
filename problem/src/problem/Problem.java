package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] nums = sc.next().split(":");
		
		int n = Integer.parseInt(nums[0]);
		int m = Integer.parseInt(nums[1]);
		
		int a, b;
		if (m > n) {
			a = m;
			b = n;
		}
		else {
			a = n;
			b = m;
		}
		
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		
		System.out.println(n / a + ":" + m / a);
	}
}