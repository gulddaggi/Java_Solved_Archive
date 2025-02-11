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
			List<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
					
					if (i == 0 && arr[0][j] == 1) {
						list.add(j);
						lines[j] = 1;
					}
				}
			}
			
			ladder:
			for (int X = 0; X < list.size(); X++) {
				if(arr[0][list.get(X)] == 1) {
					int curLine = list.get(X); // 내려가기 시작한 열 위치
					int curLineIdx = X; // 리스트에서의 인덱스
					
					for (int i = 1; i < arr.length; i++) { // 사다리를 내려가며 탐색
						if (curLine + 1 < arr.length && arr[i][curLine + 1] == 1) { // 오른쪽 사다리로 이동
							//System.out.println(curLine + " 에서 " + list.get(curLineIdx+1) + "로 이동");
							curLine = list.get(++curLineIdx);
						}
						else if (curLine - 1 >= 0 && arr[i][curLine-1] == 1) { // 왼쪽 사다리로 이동
							//System.out.println(curLine + " 에서 " + list.get(curLineIdx-1) + "로 이동");
							curLine = list.get(--curLineIdx);
						}
						
						if (arr[i][curLine] == 2) {
							System.out.println("#" + N + " " + list.get(X));
							break ladder;
						}
					}
				}
			}
		}
	}
}
