import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = sc.nextInt();
			sc.nextLine();
			
			int[][]map = new int[100][100];
			
			for(int i=0; i<100; i++) {
				String line = sc.nextLine();
				String[] tokens = line.split(" ");
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(tokens[j]);
				}
			}
			
			int startC = 0;
			for(int i=0; i<100; i++) {
				if(map[99][i] == 2) {
					startC = i;
					break;
				}
			}
			
			int r = 99;
			int c = startC;
			
			while(r > 0) {
				
				// 왼쪽으로 이동
				if(c>0 && map[r][c-1] == 1) {
					while(c>0 && map[r][c-1] ==1) {
						c--;
					}
				}
				// 오른쪽으로 이동
				else if(c<99 && map[r][c+1] == 1) {
					while(c<99 && map[r][c+1] == 1) {
						c++;
					}
				}
				
				r--;
				
				
			}
				
			System.out.println("#" + test_case + " " + c);
		}
		
		sc.close();
	}
}