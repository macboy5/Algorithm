class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        for(int i=0; i<arr.length; i++ ){
            int a = arr[i];
            if(a>=50 && a%2 ==0){
                a/=2;
            }
            else if(a<50 && a%2 !=0){
                a *=2;
            }
            arr[i] = a;
        }
        
        return arr;
    }
}