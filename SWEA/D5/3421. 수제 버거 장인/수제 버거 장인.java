import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static List<int[]> list;
	public static int N, M;
	public static boolean[] selected;
	
	public static int result;
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
	
			N = sc.nextInt();
			M = sc.nextInt();
			
			list = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list.add(new int[] {a, b});
			}
			// a,b가 동시에 버거에 들어가면 안된다.			
		
			result = 0;
			selected = new boolean[N+1];
			dfs(1);
			System.out.println("#" + test_case + " " + result);
			
			list.clear();
		}
		
		sc.close();
	}
	
	public static void dfs(int idx) {
		if(idx > N) {
			result++;
			return;
		}
		
		// 현재 재료를 넣지 않는 경우
		dfs(idx+1);
		
		// 현재 재료를 넣는 경우
		selected[idx] = true;
		
		boolean canInclude = true;
		for(int[] pair : list) {
			int a = pair[0];
			int b = pair[1];
			
			if(selected[a] && selected[b]) {
				canInclude = false;
				break;
			}
			
		}
		
		if(canInclude) {
			dfs(idx+1);
		}
		
		selected[idx] = false;
		
		
		
	}
}