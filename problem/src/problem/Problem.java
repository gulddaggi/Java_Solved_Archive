package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, List<String>> memberMap = new HashMap<>();
		HashMap<String, String> groupMap = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String group = br.readLine();
			
			int num = Integer.parseInt(br.readLine());
			
			List<String> members = new ArrayList<>();
			
			for (int j = 0; j < num; j++) {
				String member = br.readLine();
				members.add(member);
				
				groupMap.put(member, group);
			}
			
			Collections.sort(members);
			
			memberMap.put(group, members);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {			
			String question = br.readLine();
			
			int prob = Integer.parseInt(br.readLine());
			
			if (prob == 0) {				
				for (String member : memberMap.get(question)) {
					sb.append(member + "\n");
				}
			}
			else {
				sb.append(groupMap.get(question) + "\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}