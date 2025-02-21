package problem;

import java.util.Scanner;

class heap{
	int[] heap = new int[1000001];
	int heapSize;
	
	heap() {
		heapSize = 0;
	}
	
	public void push(int val) {
		heap[++heapSize] = val;
		
		int ch = heapSize;
		int p = ch / 2;
		
		while (p > 0 && heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			
			ch = p;
			p = ch / 2;
		}
	}
	
	public int pop() {
		if (heapSize == 0) {
			return -1;
		}
		
		int val = heap[1];
		
		heap[1] = heap[heapSize--];
		
		int p = 1;
		int ch = p * 2;
		
		if (ch+1 <= heapSize && heap[ch] < heap[ch+1]) ++ch;
		
		while (ch <= heapSize && heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			
			p = ch;
			ch *= 2;
			
			if (ch+1 <= heapSize && heap[ch] < heap[ch+1]) ++ch;
		}
		
		
		return val;
	}
	
}

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			System.out.print("#" + testCase + " ");
			
			heap h = new heap();
			
			for (int i = 0; i < N; i++) {
				int order = sc.nextInt();
				
				// 삽입 연산
				if (order == 1) {
					int num = sc.nextInt();
					h.push(num);
				}
				// 삭제 연산
				else {
					System.out.print( h.pop() + " ");
				}
			}
			
			System.out.println();
		}
	}
}