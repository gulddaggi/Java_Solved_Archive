package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			double val = Double.parseDouble(st.nextToken());
			
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				
				if (s.equals("@")) {
					val *= 3;
				}
				else if (s.equals("%")) {
					val += 5;
				}
				else {
					val -= 7;
				}
			}
			
			System.out.printf("%.2f\n", val);
		}
	}
}