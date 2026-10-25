class Solution {
    public int solution(int[] arr) {
        int answer = -1;
        
        while(true){
            boolean flag = true;

            for(int i=0; i<arr.length; i++){
                int before = arr[i];

                if(arr[i]>=50 && arr[i]%2==0){
                    arr[i] /= 2;
                }
                else if(arr[i]<50 && arr[i]%2 !=0){
                    arr[i] *= 2;
                    arr[i]++;
                }

                int after = arr[i];

                if(before != after ) flag = false;
            }
            answer++;
            
            if(!flag) continue;
            else return answer;
        }
        
    }
}