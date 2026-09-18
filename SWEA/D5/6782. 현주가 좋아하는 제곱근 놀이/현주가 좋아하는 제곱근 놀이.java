import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long N = sc.nextLong();
            long cnt = 0;

            while(N > 2) {
                long root = (long) Math.sqrt(N);
                
               
                if(root * root == N) {
                    N = root;
                    cnt++;
                } else {
                 
                    long nextSquare = (root + 1) * (root + 1);
                    cnt += (nextSquare - N);
                    N = nextSquare; 
                }
            }

            System.out.println("#" + test_case + " " + cnt);
        }
        sc.close();
    }
}