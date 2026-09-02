import java.util.*;
import java.io.FileInputStream;


class Solution
{
	static class Node{
		private int idx;
		private char me;
		private int leftNode = -1;
		private int rightNode = -1;
		
		Node(int idx, char me, int left, int right){
			this.idx = idx;
			this.me = me;
			this.leftNode = left;
			this.rightNode = right;
		}
		
	}
	
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);

		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
		
			int N = Integer.parseInt(sc.nextLine().trim());
			
			ArrayList<Node> list = new ArrayList<>();
			list.add(null);
			
			for(int i=1; i<=N; i++) {
				String[] tokens = sc.nextLine().trim().split(" ");
				int idx = Integer.parseInt(tokens[0]);
				char me = tokens[1].charAt(0);
				int left = tokens.length > 2 ? Integer.parseInt(tokens[2]) : -1;
				int right = tokens.length > 3 ? Integer.parseInt(tokens[3]) : -1;
				
				list.add(new Node(idx, me, left, right));
				
			}
			
			System.out.println("#" + test_case + " " + isAvailable(list, N));
		
		}
		
		sc.close();
	}
	
	public static int isAvailable(ArrayList<Node> list, int N) {
		for (int i = 1; i <= N; i++) {
			Node node = list.get(i);
			
			boolean hasChildren = (node.leftNode != -1 || node.rightNode != -1);
			
			if (hasChildren) {
				
				if (node.me != '+' && node.me != '-' && node.me != '*' && node.me != '/') {
					return 0;
				}
			} else {
				
				if (node.me < '0' || node.me > '9') {
					return 0;
				}
			}
		}
		
		return 1;
	}
	

}