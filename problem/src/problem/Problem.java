package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String king = st.nextToken();
		String stone = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		char kingAlphabet = king.charAt(0);
		char kingNumber = king.charAt(1);
		char stoneAlphabet = stone.charAt(0);
		char stoneNumber = stone.charAt(1);
		
		for (int i = 0; i < N; i++) {
			int dRow = 0;
			int dCol = 0;
			
			String order = br.readLine();
			
			for (int j = 0; j < order.length(); j++) {
				if (order.charAt(j) == 'R') {
					++dCol;
				}
				else if (order.charAt(j) == 'L') {
					--dCol;
				}
				else if (order.charAt(j) == 'B') {
					--dRow;
				}
				else if (order.charAt(j) == 'T') {
					++dRow;
				}
			}
			
			if (kingAlphabet + dCol < 'A' || kingAlphabet + dCol > 'H' || kingNumber + dRow < '1' || kingNumber + dRow > '8') {
				continue;
			}
			
			if (kingAlphabet + dCol == stoneAlphabet && kingNumber + dRow == stoneNumber) {
				if (stoneAlphabet + dCol < 'A' || stoneAlphabet + dCol > 'H' || stoneNumber + dRow < '1' || stoneNumber + dRow > '8') {
					continue;
				}
				
				kingAlphabet = stoneAlphabet;
				kingNumber = stoneNumber;
				stoneAlphabet += dCol;
				stoneNumber += dRow;
			}
			else {
				kingAlphabet += dCol;
				kingNumber += dRow;
			}
		}
		
		sb.append(kingAlphabet);
		sb.append(kingNumber + "\n");
		
		sb.append(stoneAlphabet);
		sb.append(stoneNumber + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}