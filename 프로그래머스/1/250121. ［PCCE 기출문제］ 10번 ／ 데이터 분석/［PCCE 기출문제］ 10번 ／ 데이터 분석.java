import java.util.*;

class Solution {
    public int[][] solution(int[][] datas, String ext, int val_ext, String sort_by) {

        
        /// data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후
        
        ArrayList<int[]> list = new ArrayList<>();
         
        for(int[] data : datas){
            
            if(ext.equals("code") && data[0] < val_ext){
                list.add(data);
            }
            else if(ext.equals("date") && data[1] < val_ext){
                list.add(data);
            }
            else if(ext.equals("maximum") && data[2] < val_ext){
                 list.add(data);
            }
            else if(ext.equals("remain") && data[3] < val_ext){
                 list.add(data);
            }
            
        }
        
        // sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
        if(sort_by.equals("code")){
            Collections.sort(list, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        }
        else if(sort_by.equals("date")){
            Collections.sort(list, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        }
        else if(sort_by.equals("maximum")){
            Collections.sort(list, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        }
        else if(sort_by.equals("remain")){
            Collections.sort(list, (o1, o2) -> Integer.compare(o1[3], o2[3]));
        }
        
        int[][] answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}