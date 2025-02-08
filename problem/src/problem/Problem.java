package problem;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem {
	public static int r = 0;
	public static int c = 0;
	public static int ans = 0;
	public static boolean trigger = false;
	public static int[] dx = {0, 0, 1, 1};
	public static int[] dy = {0, 1, 0, 1};
	
	public static boolean z(int n, int startX, int startY) {
		if(trigger == true) return true;
		// Z 모양 탐색을 위해 이동할 방향 배열

		
		if(n == 1) {
			for (int i = 0; i < 4; i++) {
				int nx = startX + dx[i];
				int ny = startY + dy[i];
				
				if(nx == r && ny == c) {
					trigger = true;
					return true;
				}
				else {
					ans++;
				}
			}
			
			return false;
		}
		
		for (int i = 0; i < 4; i++) {
			if(z(n/2, startX + dx[i] * n, startY + dy[i] * n)) {
				//System.out.println(n / 2 + " " + (startX + dx[i] * n) + " " + (startY + dy[i] * n));
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken()); //행
		c = Integer.parseInt(st.nextToken()); //열
		
		if(z((int)Math.pow(2, N-1), 0, 0)) {
			System.out.println(ans);
		}
	}
}
