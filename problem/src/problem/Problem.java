package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		// 빠른 입력 사용.
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//
//		int N = Integer.parseInt(st.nextToken());
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			int ans = 0;
			int combo = 0;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'O') {
					ans += (++combo);
				}
				else {
					combo = 0;
				}
			}
			System.out.println(ans);
		}
	}
}
