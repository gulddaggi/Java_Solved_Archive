package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem {
	static int N;
	static int[][] table;
	static int score;
	static boolean[] visit;
	static int[] playerList;
	
	public static void main(String[] args) throws IOException {
		// 빠른 입력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		table = new int[N][9];
		
		
		for (int i = 0; i < table.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		score = 0;
		visit = new boolean[9];
		playerList = new int[9];
		visit[0] = true;
		
		inning(0);
		
		System.out.println(score);
		
	}
	
	static void inning(int count) {
		if (count == 9) {
			score = Math.max(score, game());
			return;
		}
		
		if (count == 3) {
			playerList[count] = 0;
			inning(count + 1);
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visit[i]) {
				continue;
			}
			
			visit[i] = true;
			playerList[count] = i;
			
			inning(count + 1);
			
			visit[i] = false;
		}
	}
	
	static int game() {
		int gameScore = 0;
		
		int playerIdx = 0;
		for (int i = 0; i < N; i++) {
			int outCount = 0;
			
			boolean[] base = new boolean[4];
			while (outCount < 3) {
				int playerNumber = playerList[playerIdx];
				
				switch (table[i][playerNumber]) {
				// 아웃
				case 0:
					++outCount;
					break;
				
				// 안타
				case 1:
					base[3] = true;
					
					for (int j = 0; j < base.length-1; j++) {
						if (j == 0 && base[j]) ++gameScore;
						
						base[j] = base[j+1];
					}
					
					break;
				
				// 2루타
				case 2:
					base[3] = true;
					
					for (int j = 0; j <= 1; j++) {
						if (j <= 1 && base[j]) ++gameScore;
						
						base[j] = base[j+2];
					}
					
					base[2] = false;
					break;
				
				// 3루타
				case 3:
					for (int j = 0; j < base.length-1; j++) {
						if (base[j]) ++gameScore;
						
						base[j] = false;
					}
					
					base[0] = true;
					
					break;
				
				// 홈런
				case 4:
					base[3] = true;
					
					for (int j = 0; j < base.length; j++) {
						if (base[j]) ++gameScore;
						
						base[j] = false;
					}
					
					break;

				default:
					break;
				}
				
				playerIdx = (playerIdx + 1) % 9;
			}
		}
		
		return gameScore;
	}
	
	
}