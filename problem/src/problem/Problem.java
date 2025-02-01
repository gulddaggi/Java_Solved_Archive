package problem;

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int num = sc.nextInt();
        for(int i = 0; i < num; i++){
            int s = sc.nextInt();
            int idx = sc.nextInt();
            
            if(s == 1){
                for(int j = idx-1; j < n; j += idx)
                    arr[j] = (arr[j] == 1) ? 0 : 1;
            }
            else{
                --idx;
                arr[idx] = (arr[idx] == 1) ? 0 : 1;
                
                int val = 1;
                while(true){
                    int left = idx - val;
                    int right = idx + val;
                    
                    if(left < 0 || right >= n || arr[left] != arr[right])
                        break;
                    
                    arr[left] = (arr[left] == 1) ? 0 : 1;
                    arr[right] = (arr[right] == 1) ? 0 : 1;
                    ++val;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i != 0 && i % 20 == 0) System.out.println("");
            System.out.print(arr[i] + " ");
        }
	}
}
