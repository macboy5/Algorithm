import java.util.*;
class Solution {
    class Node{
        private int idx;
        private int x;
        private int y;
        private Node left;
        private Node right;
        
        Node(int idx, int x, int y, Node left, Node right){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }
    
    // 순회 결과를 담을 전역 리스트
    List<Integer> preList;
    List<Integer> postList;
    
    public int[][] solution(int[][] nodeinfo) {
        
        List<Node> nodeList = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++){
            nodeList.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null));         
        }
        
        nodeList.sort( (n1, n2)->{
            if(n1.y != n2.y){
                return n2.y- n1.y;
            } 
            else{
                return n1.x-n2.x;
            }
        });
        
        Node root = nodeList.get(0);
        
        for(int i=1; i<nodeList.size(); i++){
            makeTree(root, nodeList.get(i));
        }
        
        preList = new ArrayList<>();
        postList = new ArrayList<>();
        
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++){
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }
        
        return answer;
    }
    
    public void makeTree(Node parent, Node child){
        
        // left child 일 때
        if(parent.x > child.x && parent.y > child.y){
            if(parent.left == null){
                parent.left = child;
            }
            else{
                makeTree(parent.left, child);
            }
        }
        // right child 일 떼
        else if(parent.x < child.x && parent.y > child.y){
            if(parent.right == null){
                parent.right = child;
            }
            else{
                makeTree(parent.right, child);
            }
        }
    }
    
    public void preorder(Node node){
        if(node == null) return;
        preList.add(node.idx);   // 루트
        preorder(node.left);     // 왼쪽
        preorder(node.right);    // 오른쪽
    }
    
    public void postorder(Node node){
        if(node == null) return;
        postorder(node.left);    // 왼쪽
        postorder(node.right);   // 오른쪽
        postList.add(node.idx);  // 루트
    }
    
}