import java.util.*;
import java.io.FileInputStream;


class Solution
{
	public static int winCnt = 0;
	public static int loseCnt = 0;
	public static int[] gyuCard;
	public static int[] inCard;
	public static boolean[] isUsed;
	
	public static void main(String args[]) throws Exception
	{
		
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			winCnt = 0;
			loseCnt = 0;
			gyuCard = new int[9];
			for(int i=0; i<9; i++) {
				gyuCard[i] = sc.nextInt();
			}
			
			boolean[] hasCard = new boolean[19];
			for(int i=0; i<9; i++) {
				hasCard[gyuCard[i]] = true;
			}

			inCard = new int[9];
			int idx=0;
			for(int i=1; i<=18; i++) {
				if(!hasCard[i]) inCard[idx++] = i;
			}
			isUsed = new boolean[9];
			func(0,0,0);
			
			
			System.out.println("#" + test_case + " " + winCnt + " " + loseCnt);
		}
		
		sc.close();
	}
	
	public static void func(int cnt, int gyuScore, int inScore) {
		if(cnt == 9) {
			if(gyuScore > inScore) winCnt++;
			else if(gyuScore < inScore) loseCnt++; 
			return;
		}

		for(int i=0; i<9; i++) {
			if(isUsed[i]) continue;
			
			isUsed[i] = true;
			
			int score = gyuCard[cnt] + inCard[i];
			
			if(gyuCard[cnt] > inCard[i]) {
				func(cnt+1, gyuScore + score, inScore);
			}
			else if(gyuCard[cnt] < inCard[i]) {
				func(cnt+1, gyuScore , inScore + score);
			}
			
			isUsed[i] = false;
			
			
			
		}
	}
	
	
}