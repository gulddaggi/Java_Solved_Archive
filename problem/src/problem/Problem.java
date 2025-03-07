package problem;

import java.util.Scanner;

public class Problem {
	static int[] kyCards;
	static int[] iyCards;
	static boolean[] handed;
	static int win;
	static int lose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			kyCards = new int[9];
			iyCards = new int[9];
			
			int[] totalCards = new int[19];
			
			for (int i = 0; i < kyCards.length; i++) {
				kyCards[i] = sc.nextInt();
				
				++totalCards[kyCards[i]];
			}
			
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (totalCards[i] == 0) {
					iyCards[idx++] = i;
				}
			}
			
			handed = new boolean[9];
			win = 0;
			lose = 0;
			
			func(0, 0, 0);
			
			System.out.println("#" + testCase + " " + win  + " " + lose);
		}
	}
	
	static void func(int count, int kyVal, int iyVal) {
		if (count == 9) {
			if (kyVal > iyVal) ++win;
			else if (kyVal < iyVal) ++lose;
			
			return;
		}
		
		for (int i = 0; i < kyCards.length; i++) {
			if (handed[i]) continue;
			
			handed[i] = true;
			
			int sum = kyCards[count] + iyCards[i];
			if (kyCards[count] > iyCards[i]) func(count + 1, kyVal + sum, iyVal);
			else if (kyCards[count] < iyCards[i]) func(count + 1, kyVal, iyVal + sum);
						
			handed[i] = false;
		}
	}
}