package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] scores = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] limits = new int[N-M+1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < limits.length; i++) {
			limits[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int count = N;
		int idx = 0;
		int round = 0;
		
		Stack<Integer> tmp = new Stack<>();
		
		while (count != 0) {
			int addCount = M - pq.size();
			
			for (int i = 0; i < addCount; i++) {
				pq.add(scores[idx++]);
			}
			
			for (int i = 0; i < limits[round]; i++) {
				tmp.add(pq.poll());
			}
			
			tmp.pop();
			
			while (!tmp.isEmpty()) {
				pq.add(tmp.pop());
			}
			
			count -= addCount;
			round++;
		}
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}
}