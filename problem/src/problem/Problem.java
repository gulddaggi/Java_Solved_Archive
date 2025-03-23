package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int val = Integer.parseInt(st.nextToken());
			arr[i] = arr[i-1] + val;
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] - arr[j] == M) {
					++ans;
				}
			}
		}
		
		System.out.println(ans);
	}
}