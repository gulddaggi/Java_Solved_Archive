package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Robot implements Comparable<Robot>{
	double time;
	int idx;
	
	public Robot(double time, int idx) {
		this.time = time;
		this.idx = idx;
	}

	@Override
	public int compareTo(Robot o) {
		if (this.time - o.time > 0) {
			return 1;
		}
		else if (this.time - o.time < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		
		Robot robots[] = new Robot[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			double dist = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
			robots[i] = new Robot(dist / V, i+1);
		}
		
		Arrays.sort(robots);
		
		for (int i = 0; i < robots.length; i++) {
			System.out.println(robots[i].idx);
		}
	}
}