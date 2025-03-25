package problem;

import java.util.Scanner;

class Record {
	int l;
	int r;
	int s;

	public Record() {

	}

	public Record(int l, int r, int s) {
		this.l = l;
		this.r = r;
		this.s = s;
	}
}

public class Problem {
	static int N;
	static int X;
	static int M;
	static Record[] records;
	static int[] nums;
	static int[] ans;
	static boolean found;

	public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt(); // 햄스터 우리 개수
			X = sc.nextInt(); // 우리 별 최대 햄스터 마리수
			M = sc.nextInt(); // 기록 개수

			records = new Record[M];
			ans = new int[N];
			nums = new int[N];
			found = false;

			for (int i = 0; i < M; i++) {
				// ㅣ번 우리에서 r번 우리까지의 햄스터 수를 세었더니 s마리
				int l = sc.nextInt();
				int r = sc.nextInt();
				int s = sc.nextInt();

				records[i] = new Record(l, r, s);
			}

			func(N - 1);

			if (!found) {
				System.out.print("#" + testCase + " " + -1);
			} else {
				System.out.print("#" + testCase + " ");
				for (int i = 0; i < N; i++) {
					System.out.print(ans[i] + " ");
				}
			}

			System.out.println();
		}
	}

	static void func(int count) {
		if (count == -1) {
			for (int i = 0; i < M; i++) {
				Record rec = records[i];
				int val = 0;
				for (int j = rec.l - 1; j <= rec.r - 1; j++) {
					val += nums[j];
				}
				if (val != rec.s)
					return;
			}

			found = true;

			int numsTotal = 0;
			for (int i = 0; i < N; i++) {
				numsTotal += nums[i];
			}

			int ansTotal = 0;
			if (found) {
				for (int i = 0; i < N; i++) {
					ansTotal += ans[i];
				}
			}

			boolean change = false;

			if (!found || numsTotal > ansTotal) {
				change = true;
			} else if (numsTotal == ansTotal) {
				for (int i = 0; i < N; i++) {
					if (nums[i] < ans[i]) {
						change = true;
						break;
					} else if (nums[i] > ans[i]) {
						break;
					}
				}
			}

			if (change) {
				for (int i = 0; i < N; i++) {
					ans[i] = nums[i];
				}
			}

			return;
		}

		for (int i = X; i >= 0; i--) {
			nums[count] = i;
			func(count - 1);
		}
	}
}