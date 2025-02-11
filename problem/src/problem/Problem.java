package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[100][100];
		for (int t = 0; t < 10; t++) {
			int N = sc.nextInt();
			int[] lines = new int[100];
			int startLine = 0;
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();

					if (i == 0 && arr[0][j] == 1) {
						list.add(j);
						lines[j] = 1;
					}

					if (arr[i][j] == 2) {
						startLine = j;
					}
				}
			}
			
			int curLine = startLine; // 내려가기 시작한 열 위치
			int curLineIdx = 0; // 리스트에서의 인덱스
			for (int X = 0; X < list.size(); X++) 
				if(list.get(X) == startLine) curLineIdx = X;		
		
			for (int i = 99; i >= 0; i--) { // 사다리를 올라가며 탐색
				if (curLine + 1 < arr.length && arr[i][curLine + 1] == 1) { // 오른쪽 사다리로 이동
					curLine = list.get(++curLineIdx);
				} else if (curLine - 1 >= 0 && arr[i][curLine - 1] == 1) { // 왼쪽 사다리로 이동
					curLine = list.get(--curLineIdx);
				}

				if (i == 0) 
					System.out.println("#" + N + " " + curLine);
			}
		}
	}
}
