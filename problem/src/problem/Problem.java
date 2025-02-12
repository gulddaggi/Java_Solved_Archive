package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] arr = new char[100][];
		for (int t = 0; t < 10; t++) {
			int T = sc.nextInt();
			
			int ans = 0;
			int left = 0;
			int right = 0;
			for (int i = 0; i < arr.length; i++) {
				char[] line = sc.next().toCharArray(); // 입력받은 문자열을 문자 배열로 변환
				arr[i] = line;
			}
			
			for (int i = 0; i < arr.length; i++) {	
				for (int j = 0; j < arr.length; j++) {
					for (int k = 0; k < arr.length; k++) {
						// 회문 탐색을 위한 인덱스 설정.
						left = j;
						right = k;
						
						// 가로 세로 회문 여부
						boolean verPass = true;
						boolean horPass = true;
						
						int verLen = 0;
						int horLen = 0;
						
						// 가로 세로 동시 회문 탐색
						while (left <= right) {
							// 가로 회문 탐색
							if (horPass && arr[i][left] == arr[i][right])
			                    horLen = (left == right) ? horLen + 1 : horLen + 2;
							else 
			                    horPass = false;
							
							// 세로 회문 탐색
							if (verPass && arr[left][i] == arr[right][i])  
								verLen = (left == right) ? verLen + 1 : verLen + 2;
							else 
								verPass = false;
							
							// 둘 다 회문이 아닐 경우
							if (!horPass && !verPass)
								break;
							
							++left;
							--right;
						}
						
						// 가장 긴 회문 갱신
						if (horPass) 
							ans = Math.max(ans, horLen);
						
						if (verPass) 
							ans = Math.max(ans, verLen);
					}
				}
			}
			
			System.out.println("#" + T + " " +ans);
		}
	}
}
