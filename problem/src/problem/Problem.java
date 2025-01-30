package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int ans = 0;
		for (int i = 0; i < N; i++) {
			int[] arr = new int[3];
			int total = 0;
			boolean test = true;
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				total += arr[j];
				if (arr[j] < L) {
					test = false;
				}
			}

			if (test && total >= K) {
				ans++;
				sb.append(arr[0] + " ");
				sb.append(arr[1] + " ");
				sb.append(arr[2] + " ");
			}
		}

		System.out.println(ans);
		System.out.println(sb);
	}
}
