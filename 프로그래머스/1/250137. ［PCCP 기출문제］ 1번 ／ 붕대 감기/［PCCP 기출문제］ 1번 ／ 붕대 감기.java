class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        // bandage는 [시전 시간, 초당 회복량, 추가 회복량] 
        int attackCnt = attacks.length;
        
        int time = 0, maxTime = attacks[attackCnt-1][0];
        int continuous = 0;
        int init = health;
        int idx = 0;
        
        while(time <= maxTime){         
            
            if(time == attacks[idx][0]){
                //공격받는 시점
                continuous = 0;
                health -= attacks[idx][1];
                idx++;
                if(health <=0) return -1;
            }
            else{
                // 회복 시점
                continuous++;
                health += bandage[1];
                if(continuous == bandage[0]){
                    health += bandage[2];
                    continuous = 0;
                }
                if(init < health) health = init;
            }
            time++;
            
            // System.out.println("time : " + time + " health : "+ health);
            

        }
        
        return health;
    }
}