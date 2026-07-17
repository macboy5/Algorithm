class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int[] days = new int[13];
        days[0] = 0;
        days[1] = 31;
        days[2] = 29;
        days[3] = 31;
        days[4] = 30;
        days[5] = 31;
        days[6] = 30;
        days[7] = 31;
        days[8] = 31;
        days[9] = 30;
        days[10] = 31;
        days[11] = 30;
        days[12] = 31;
        
        int total = 0;
        for(int i=0; i<a; i++){
            total += days[i];
        }
        total += (b-1);
        
        int tmp = total % 7;
        
        switch(tmp){
            case 0 : return "FRI";
            case 1 : return "SAT";
            case 2 : return "SUN";
            case 3 : return "MON";
            case 4 : return "TUE";
            case 5 : return "WED";
            case 6 : return "THU";
            case 7 : return "FRI";
        }
        
        
        return answer;
    }
}