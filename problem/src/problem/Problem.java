package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();

			int[] trees = new int[N];
			int hightest = 0;
			for (int i = 0; i < N; i++) {
				trees[i] = sc.nextInt();

				hightest = Math.max(trees[i], hightest);
			}

			int day = 0;
			int height = 1;
			while (true) {
				int remain = 0;
				
				for (int i = 0; i < trees.length; i++) {
					if (trees[i] != hightest) {
						++remain;
					}
				}

				if (remain == 0) {
					break;
				}

				boolean passExist = true;
				int target = -1;
				for (int i = 0; i < trees.length; i++) {
					if (trees[i] + height == hightest) {
						target = i;
						break;
					} else if (trees[i] + height < hightest) {
						if (height == 1 && hightest - trees[i] == 2) {
							if (passExist) {
								passExist = false;
								continue;
							}
						}
						
						target = i;
					}
				}
				
				if (target != -1) trees[target] += height;
				
				++day;
				height = (height == 1) ? 2 : 1;
			}

			System.out.println("#" + testCase + " " + day);
		}

	}
}