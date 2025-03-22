package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr1 = new int[N];
		int[] arr2 = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st.nextToken());
		
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int p1 = 0;
		int p2 = 0;
		
		while (p1 < N && p2 < M) {
			if (arr1[p1] <= arr2[p2]) sb.append(arr1[p1++] + " ");
			else sb.append(arr2[p2++] + " ");
		}
		
		while (p1 < N) sb.append(arr1[p1++] + " ");
		
		
		while (p2 < M) sb.append(arr2[p2++] + " ");
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}