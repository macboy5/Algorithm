import java.util.*;

class Solution {
    
    class Node{
        
        String name;
        int profit = 0;
        Node parent = null;
        
        Node(String name, int profit){
            this.name = name;
            this.profit = profit;
        }
        
        void distributeProfit(int profit){
            int parentProfit = profit/10;
            int myProfit = profit - parentProfit;
            
            this.profit += myProfit;
            
            if(parent != null && parentProfit > 0) this.parent.distributeProfit(parentProfit);
            
        }
               
    }
    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Node[] nodes = new Node[enroll.length];
        HashMap<String, Integer> hm = new HashMap<>();
        
        
        for(int i=0; i<enroll.length; i++){
            nodes[i] = new Node(enroll[i], 0); 
            hm.put(enroll[i], i);
        }
        
        for(int i=0; i<referral.length; i++){
                
            if(referral[i].equals("-")) continue;
            
            // referral[i] : enroll[i]를 조직에 참여시킨 사람의 이름 --> referral[i]가 enroll[i]의 parent
            int idx = hm.getOrDefault(referral[i], -1);
            if(idx==-1) continue;
            
            nodes[i].parent = nodes[idx];
                
        }
        
        // 판매이익 분배
        
        //seller[i] : i 번째 판매 집계 데이터가 어느 판매원에 의한 것인지
        for(int i=0; i<seller.length; i++){
            
            int profit = amount[i]*100;
            int idx = hm.getOrDefault(seller[i], -1);
            if(idx == -1) continue;
            
            nodes[idx].distributeProfit(profit);
            
        }
        
        for(int i=0; i<nodes.length; i++){
            answer[i] = nodes[i].profit;
        }
        
        
        return answer;
    }
}