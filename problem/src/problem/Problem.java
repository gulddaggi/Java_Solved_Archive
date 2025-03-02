package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem {
	static int N;
	static int[][] board;
	static int[][] game;
	static int[] directions;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer sT = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(sT.nextToken());
		board = new int[N][N];
		directions = new int[5];
		
		for (int i = 0; i < N; i++) {
			sT = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(sT.nextToken());
			}
		}
		
		func(0);

		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void func(int depth) {
		if (depth == 5) {
			// 배열 깊은 복사
			game = new int[N][N];
			for (int i = 0; i < N; i++) {
				game[i] = board[i].clone();
			}
			
			// 게임 진행
			simulation();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans = Math.max(ans, game[i][j]);
				}
			}
			return;
		}
		
		for (int i = 0; i < 5; i++) {
			directions[depth] = i;	
			func(depth + 1);
		}
		
	}
	
	static void simulation() {
		for (int i = 0; i < 5; i++) {
			// 위
			if (directions[i] == 0) {
				for (int col = 0; col < N; col++) {
					boolean isAdd = false;
					Stack<Integer> st = new Stack<>();
					// 방문하며 값 계산 및 재배치
					for (int row = 0; row < N; row++) {
						// 0이면 패스
						if (game[row][col] == 0) {
							continue;
						}
						
						if (st.isEmpty()) {
							st.add(game[row][col]);
						}
						else {
							// 값이 같으면 기존 덧셈 여부에 따라 계산 및 추가
							if (st.peek() == game[row][col]) {
								// 이미 한번 더한 값인 경우, 더하지 않고 추가
								if (isAdd) {
									// 추가되는 수는 더할 수 있으므로 체크 초기화
									isAdd = false;
									st.add(game[row][col]);
								}
								// 더하지 않은 값인 경우, top의 값을 제거하고 두 수의 덧셈을 추가
								else {
									isAdd = true;
									st.add(st.pop() + game[row][col]);
								}
							}
							// 값이 다르면 스택에 추가
							else {
								isAdd = false;
								st.add(game[row][col]);
							}
						}
						
						// 방문한 값 초기화
						game[row][col] = 0;
					}
					
					//다시 배열 저장
					int idx = st.size()-1;
					while (!st.isEmpty()) {
						game[idx--][col] = st.pop();
					}
				}
			}
			// 아래
			else if(directions[i] == 1) {
				for (int col = 0; col < N; col++) {
					boolean isAdd = false;
					Stack<Integer> st = new Stack<>();
					// 방문하며 값 계산 및 재배치
					for (int row = N-1; row >= 0; row--) {
						// 0이면 패스
						if (game[row][col] == 0) {
							continue;
						}
						
						if (st.isEmpty()) {
							st.add(game[row][col]);
						}
						else {
							// 값이 같으면 기존 덧셈 여부에 따라 계산 및 추가
							if (st.peek() == game[row][col]) {
								// 이미 한번 더한 값인 경우, 더하지 않고 추가
								if (isAdd) {
									// 추가되는 수는 더할 수 있으므로 체크 초기화
									isAdd = false;
									st.add(game[row][col]);
								}
								// 더하지 않은 값인 경우, top의 값을 제거하고 두 수의 덧셈을 추가
								else {
									isAdd = true;
									st.add(st.pop() + game[row][col]);
								}
							}
							// 값이 다르면 스택에 추가
							else {
								isAdd = false;
								st.add(game[row][col]);
							}
						}
						
						// 방문한 값 초기화
						game[row][col] = 0;
					}
					
					// 다시 배열에 저장
					int idx = (N-1) - (st.size()-1);
					while (!st.isEmpty()) {
						game[idx++][col] = st.pop();
					}
				}
			}
			// 오른쪽
			else if (directions[i] == 2) {
				for (int row = 0; row < N; row++) {
					boolean isAdd = false;
					Stack<Integer> st = new Stack<>();
					// 방문하며 값 계산 및 재배치
					for (int col = N-1; col >= 0; col--) {
						// 0이면 패스
						if (game[row][col] == 0) {
							continue;
						}
						
						if (st.isEmpty()) {
							st.add(game[row][col]);
						}
						else {
							// 값이 같으면 기존 덧셈 여부에 따라 계산 및 추가
							if (st.peek() == game[row][col]) {
								// 이미 한번 더한 값인 경우, 더하지 않고 추가
								if (isAdd) {
									// 추가되는 수는 더할 수 있으므로 체크 초기화
									isAdd = false;
									st.add(game[row][col]);
								}
								// 더하지 않은 값인 경우, top의 값을 제거하고 두 수의 덧셈을 추가
								else {
									isAdd = true;
									st.add(st.pop() + game[row][col]);
								}
							}
							// 값이 다르면 스택에 추가
							else {
								isAdd = false;
								st.add(game[row][col]);
							}
						}
						
						// 방문한 값 초기화
						game[row][col] = 0;
					}
					
					// 다시 배열에 저장
					int idx = (N-1) - (st.size()-1);
					while (!st.isEmpty()) {
						game[row][idx++] = st.pop();
					}
				}
			}
			// 왼쪽
			else {
				for (int row = 0; row < N; row++) {
					boolean isAdd = false;
					Stack<Integer> st = new Stack<>();
					// 방문하며 값 계산 및 재배치
					for (int col = 0; col < N; col++) {
						// 0이면 패스
						if (game[row][col] == 0) {
							continue;
						}
						
						if (st.isEmpty()) {
							st.add(game[row][col]);
						}
						else {
							// 값이 같으면 기존 덧셈 여부에 따라 계산 및 추가
							if (st.peek() == game[row][col]) {
								// 이미 한번 더한 값인 경우, 더하지 않고 추가
								if (isAdd) {
									// 추가되는 수는 더할 수 있으므로 체크 초기화
									isAdd = false;
									st.add(game[row][col]);
								}
								// 더하지 않은 값인 경우, top의 값을 제거하고 두 수의 덧셈을 추가
								else {
									isAdd = true;
									st.add(st.pop() + game[row][col]);
								}
							}
							// 값이 다르면 스택에 추가
							else {
								isAdd = false;
								st.add(game[row][col]);
							}
						}
						
						// 방문한 값 초기화
						game[row][col] = 0;
					}
					
					// 다시 배열에 저장
					int idx = st.size()-1;
					while (!st.isEmpty()) {
						game[row][idx--] = st.pop();
					}
				}
			}
		}
	}
}