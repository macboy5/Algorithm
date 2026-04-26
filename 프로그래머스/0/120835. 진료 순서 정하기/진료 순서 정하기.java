class Solution {
    public int[] solution(int[] emergency) {
        
        int length = emergency.length;
        
        
        int[] result = new int[length];
        
        int rank = 1;
        int max = -1;
        int idx = -1;
        
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                
                if(emergency[j] > max) {
                    max = emergency[j];
                    idx = j;
                }
                
            }
            result[idx] = rank++;
            emergency[idx] = -1;
            max = -1;
            
        }
        
        
        

        return result;
    }
}