package problem;

import java.util.Scanner;

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			int[] posArr = new int[8];
			for (int j = 0; j < posArr.length; j++) {
				posArr[j] = sc.nextInt();
			}
			
			Pos lb1 = new Pos(posArr[0], posArr[1]);
			Pos ru1 = new Pos(posArr[2], posArr[3]);
			Pos lb2 = new Pos(posArr[4], posArr[5]);
			Pos ru2 = new Pos(posArr[6], posArr[7]);
			
			char ans = ' ';
			
			if (ru1.x < lb2.x || ru2.x < lb1.x || ru1.y < lb2.y || ru2.y < lb1.y) { // d
				ans = 'd';
			}
			else { // ru1.x >= lb2.x || ru2.x >= lb1.x
				if ((ru1.x == lb2.x && (ru1.y == lb2.y || lb1.y == ru2.y)) || 
						(ru2.x == lb1.x && (ru2.y == lb1.y || lb2.y == ru1.y))){ // c
					ans = 'c';
				}
				else {
					if ((ru1.x == lb2.x && (lb2.y < ru1.y && ru2.y > lb1.y)) ||
							(lb1.y == ru2.y && (ru1.x > lb2.x && lb1.x < ru2.x))||
							(ru2.x == lb1.x && (lb1.y < ru2.y && ru1.y > lb2.y)) ||
							(ru1.y == lb2.y && (ru2.x > lb1.x && lb2.x < ru1.x))) { // b
						ans = 'b';
					}
					else{
						ans = 'a';
					}
				}
			}
			
			System.out.println(ans);
		}
	}
}
