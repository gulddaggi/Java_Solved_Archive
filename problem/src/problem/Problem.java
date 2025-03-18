package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pos{
	int row;
	int col;
	
	public Pos() {
		
	}
	
	public Pos(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Problem {
	static int N;
	static int M;
	static List<Pos> houseList;
	static List<Pos> chickenList;
	static boolean[] check;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				
				if (val == 1) {
					houseList.add(new Pos(i, j));
				}
				else if (val == 2) {
					chickenList.add(new Pos(i, j));
				}
			}
		}
		
		check = new boolean[chickenList.size()];
		ans = Integer.MAX_VALUE;
		func(0, 0);
		System.out.println(ans);
	}
	
	static void func(int count, int idx) {
		if (count == M) {
			ans = Math.min(ans, calc());
			
			return;
		}
		
		for (int i = idx; i < chickenList.size(); i++) {
			check[i] = true;
			
			func(count + 1, i + 1);
			
			check[i] = false;
		}
	}
	
	static int calc() {
		int total = 0;
		
		for (Pos housePos : houseList) {
			int dist = Integer.MAX_VALUE;
			for (int i = 0; i < check.length; i++) {
				if (check[i]) {
					Pos chickenPos = chickenList.get(i);
					int temp = Math.abs(housePos.row - chickenPos.row) + Math.abs(housePos.col - chickenPos.col);
					dist = Math.min(dist, temp);
				}
			}
			
			total += dist;
		}
		
		return total;
	}
}