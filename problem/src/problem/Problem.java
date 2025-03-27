package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem {
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p  = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			p[i] = -1;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (order == 0) {
				union(a, b);
			}
			else {
				if (find(a) == find(b)) {
					sb.append("YES\n");
				}
				else {
					sb.append("NO\n");
				}
				
				bw.write(sb.toString());
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	static int find(int x) {
		if (p[x] < 0) {
			return x;
		}

		return p[x] = find(p[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return;
		
		if (p[b] < p[a]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if (p[a] == p[b]) p[a]--;
		
		p[b] = a;
	}
}