package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {
	static int N;
	static int[][] table;
	static boolean[] visit;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			
			table = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			visit = new boolean[N];
			ans = Integer.MAX_VALUE;
			
			pick(0, 0);
			
			System.out.println("#" + testCase + " " + ans);
		}

	}
	
	static void pick(int count, int idx) {
		if (count == N / 2) {
			ans = Math.min(ans, cook());
			return;
		}
		
		if (idx == N) {
			
			return;
		}
		
		visit[idx] = true;
		pick(count + 1, idx + 1);
		visit[idx] = false;
		pick(count, idx + 1);
	}
	
	static int cook() {
		List<Integer> foodsA = new ArrayList<>();
		List<Integer> foodsB = new ArrayList<>();
		
		for (int i = 0; i < visit.length; i++) {
			if (visit[i]) foodsA.add(i);
			else foodsB.add(i);
		}
		
		int sumA = 0;
		int sumB = 0;
		
		for (int i = 0; i < foodsA.size()-1; i++) {
			for (int j = i+1; j < foodsA.size(); j++) {
				int iVal = foodsA.get(i);
				int jVal = foodsA.get(j);
				sumA += (table[iVal][jVal] + table[jVal][iVal]);
			}
		}
		
		for (int i = 0; i < foodsB.size()-1; i++) {
			for (int j = i+1; j < foodsB.size(); j++) {
				int iVal = foodsB.get(i);
				int jVal = foodsB.get(j);
				sumB += (table[iVal][jVal] + table[jVal][iVal]);
			}
		}
		
		
		return Math.abs(sumA - sumB);
		
	}
	
}