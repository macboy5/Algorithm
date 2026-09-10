import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static int N;
	public static int[] arr;
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int result = 0;
			
			N = sc.nextInt();
			arr = new int[N];
			for(int i = 0; i < N; i++) {
			    arr[i] = sc.nextInt();
			}
			
			int peek = -1;
			int leftLen = 0;
			int rightLen = 0;
			for(int i=1 ; i<N-1; i++) {
				
				leftLen = 0;
				rightLen = 0;
				
				if(arr[i-1] < arr[i] && arr[i] > arr[i+1] ) {
					peek = i;
					
					for(int j=i; j>=1 ; j--) {
						if(arr[j-1] < arr[j]) {
							leftLen++;
						}
						else break;
					}
					
					for(int j=i; j<N-1; j++) {
						if(arr[j] > arr[j+1]) {
							rightLen++;
						}
						else break;
					}

					result += leftLen * rightLen;
				}
				
			}
			
			
			
			System.out.println("#" + test_case + " " + result);
		}
		
		sc.close();
	}
}