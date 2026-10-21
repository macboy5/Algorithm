import java.util.*;

class Solution {
    
    class Node{
        
        Node prev = null;
        Node next = null;
        boolean removed = false;
        
        void deleteRow(){
            this.removed = true;
            deleted.push(this);
            
            if(prev != null) prev.next = this.next;
            if(next != null) next.prev = this.prev;
        }
        
        void restore(){
            this.removed = false;
            
            if(prev != null) prev.next = this;
            if(next != null) next.prev = this;
            
        }
        
    }
    
    Stack<Node> deleted = new Stack<>();
    
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        Node[] nodes = new Node[n];
        
        for(int i=0; i<n; i++){
            nodes[i] = new Node();
        }
        
        for(int i=0; i<n ; i++){
            if(i >= 1) nodes[i].prev = nodes[i-1];
            if(i < n-1) nodes[i].next = nodes[i+1];
        }
        
        Node cur = nodes[k];
        
        for(String s : cmd){
            char c = s.charAt(0);
            
            if(c == 'U'){
                int num = Integer.parseInt(s.substring(2));
                while (num-- > 0 && cur.prev != null) {
                    cur = cur.prev;
                }              
            }
            else if(c == 'D'){
                int num = Integer.parseInt(s.substring(2));
                while(num-- > 0 && cur.next != null){
                    cur = cur.next;
                }
            }
            else if(c == 'C'){ // 현재 행 삭제
                Node node = cur;
                node.deleteRow();
                
                // 마지막 행 삭제시
                if(node.next == null){
                    cur = node.prev;
                }
                else cur = node.next;
                
            }
            else if(c == 'Z'){ // 복원
                Node node = deleted.pop();   
                node.restore();
                
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].removed) sb.append("X");
            else sb.append("O");
        }
        
        
        return sb.toString();
    }
}