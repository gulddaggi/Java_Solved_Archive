package problem;

import java.util.Scanner;

public class Problem {
	static int N;
	static int K;
	static int[] arr;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			arr = new int[N];
			int total = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				total += arr[i];
			}
			
			ans = 0;
			
			if (total >= K) func(0, 0);
			
			System.out.println("#" + testCase + " " + ans);
		}
	}
	
	static void func(int idx, int val) {
        if (val > K) return;
		
        if (val == K) {
        	ans++;
        	return;
        }
		
        if(idx >= N) return;
        
        func(idx + 1, val + arr[idx]);
        
        func(idx + 1, val);
	}
}
