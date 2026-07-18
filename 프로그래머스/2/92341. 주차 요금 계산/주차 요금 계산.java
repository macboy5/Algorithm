import java.util.*;

class Solution {
    public Long[] solution(int[] fees, String[] records) {
        Long[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();
        ArrayList<Long> list = new ArrayList<>();
        
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int sliceMin = fees[2];
        int sliceFee = fees[3];
        long fee = 0;
        int diff = 0;
        
        for(String record : records){
            
            String hh = "";
            String mm = "";
            
            hh = record.substring(0,2);
            mm = record.substring(3,5);
            
            int hour = Integer.parseInt(hh);
            int min = Integer.parseInt(mm);
            

            int time = 60*hour + min;
            String carNum = record.substring(6,10);
            String isIn = record.substring(11);
                           
            if(isIn.equals("IN")){
                map.put(carNum, time);
                
            }
            else if(isIn.equals("OUT")){
                int beforeTime = map.get(carNum);
                

                diff = time - beforeTime;

                map.remove(carNum);
                
                result.put(carNum, result.getOrDefault(carNum , 0) + diff);

            }
            
            
        }
        
        int max = 23*60 + 59;
        // 안나간 차량 처리
        for(String key : map.keySet()){
            String carNum = key;
            int time = map.get(key);
            
            diff = max -time;

             // map.remove(carNum);
                
            result.put(carNum, result.getOrDefault(carNum , 0) + diff);
        }
        
        
        for(String key : result.keySet()){
                    
            fee = defaultFee;
            diff = result.get(key);
                if(diff > defaultTime){
                    if((diff-defaultTime)%sliceMin==0){
                        fee += ((diff-defaultTime)/sliceMin)*sliceFee;
                    }
                    else{
                        fee += ((diff-defaultTime)/sliceMin +1 ) *sliceFee;
                    }
                }
            
           
            
            list.add(fee);
        }
        

        
        
        answer = new Long[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        

        return answer;
    }
}