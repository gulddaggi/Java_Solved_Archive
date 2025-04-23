package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int[] changes = {25, 10, 5, 1};
		
		while (T-- != 0) {
			StringBuilder sb = new StringBuilder();
			int C = Integer.parseInt(br.readLine());
			
			int[] answer = {0, 0, 0, 0};
			for (int i = 0; i < changes.length; i++) {
				answer[i] = C / changes[i];
				C -= (answer[i] * changes[i]);
				sb.append(answer[i] + " ");
			}
			
			
			bw.write(sb.toString() + "\n");
			bw.flush();
		}
		
		bw.close();
	}
}