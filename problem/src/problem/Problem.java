package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		
		HashMap<String, Character> map = new HashMap<>();
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			char result = st.nextToken().charAt(0);
			
			map.put(name, result);
		}
		
		int score = 0;
		boolean isWin = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			
			if (map.get(name) == null) score -= L;
			else if (map.get(name) == 'W') score += W;
			else score -= L;
			
			if (score < 0) score = 0;
			
			if (score >= G) isWin = true;
		}
		
		if (isWin) sb.append("I AM NOT IRONMAN!!");
		else sb.append("I AM IRONMAN!!");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}