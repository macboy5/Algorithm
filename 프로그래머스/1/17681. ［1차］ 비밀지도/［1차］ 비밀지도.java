class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        char map[][] = new char[n][n];     
        char map1[][] = new char[n][n];
        char map2[][] = new char[n][n];
        // 둘 다 0일 때만 0, 하나라도 1이면 1
        
        for(int i=0; i<n; i++){
            int num = arr1[i];
            String binary = Integer.toBinaryString(num);
            String tmp = "";
            for(int j=0 ; j<n-binary.length(); j++){
                tmp += "0";
            }
            binary = tmp + binary;
            
   //         System.out.println(binary);
            
            map1[i] = binary.toCharArray();
            
        }

        for(int i=0; i<n; i++){
            int num = arr2[i];
            String binary = Integer.toBinaryString(num);
            String tmp = "";
            for(int j=0 ; j<n-binary.length(); j++){
                tmp += "0";
            }
            binary = tmp + binary;
            
   //         System.out.println(binary);
            
            map2[i] = binary.toCharArray();
            
        }
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map1[i][j] == '0' && map2[i][j]=='0'){
                    map[i][j] = ' ';

                }
                                    else map[i][j] = '#';
            }
        }
        
        for(int i=0; i<n; i++){
            String tmp = "";
            for(int j=0; j<n ; j++){
                tmp += map[i][j];
            }
            answer[i] = tmp;
        }
        
        
        
        return answer;
    }
}