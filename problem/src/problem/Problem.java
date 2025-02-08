package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (M % K == 0) {
			sb.append("Yes");
		}
		else {
			sb.append("No");
		}
		
		System.out.println(sb);
	}
}
