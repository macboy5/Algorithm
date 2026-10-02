import java.util.*;

class Solution {
    
    class File{
        String head; // 숫자가 아닌 문자
        String number; //  한 글자에서 최대 다섯 글자 사이의 연속된 숫자
        String tail; // 그 나머지 부분으로, 여기에는 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.
        int idx;
        
        File(String head, String number, String tail, int idx){
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }
        
    }
    
    public String[] solution(String[] files) {
        
        
        List<File> fileList = new ArrayList<>();
        int idx = 0;
        
        for(String file : files){
            
            boolean headDone = false, numberDone = false;
            
            String head = "";
            String number = "";
            String tail = "";
            int numberCnt = 0;
            
            for(int i=0; i< file.length(); i++){
                char c = file.charAt(i);
                
                if(!headDone){
                    if( c >= '0' && c<= '9'){
                        i--;
                        headDone = true;
                    }
                    else head += file.charAt(i);
                }
                else if(headDone && !numberDone){
                    if(c >= '0' && c <= '9' && numberCnt < 5){
                        number += c;
                        numberCnt++;
                    }
                    else{
                        numberDone = true;
                        i--;
                    }
                }
                else if(headDone && numberDone)  tail += c;
                    
            }
            
            
            fileList.add(new File(head, number, tail, idx++));
            
        }
        
        fileList.sort((f1, f2) -> {
            String head1 = f1.head.toUpperCase();
            String head2 = f2.head.toUpperCase();

            // 1. HEAD가 같을 때
            if (head1.equals(head2)) {
                int num1 = Integer.parseInt(f1.number);
                int num2 = Integer.parseInt(f2.number);

                // NUMBER가 같으면 원래 순서(idx) 비교
                if (num1 == num2) {
                    return f1.idx - f2.idx;
                } 
                // NUMBER가 다르면 숫자의 크기로 비교
                else {
                    return Integer.compare(num1, num2); // 또는 return num1 - num2;
                }
            } 
            // 2. HEAD가 다를 때 (대소문자 무시한 HEAD 순 정렬)
            else {
                return head1.compareTo(head2);
            }
        });
        
        String[] answer = new String[fileList.size()];
        
        for(int i=0; i<idx; i++){
            
            File file = fileList.get(i);
            String filename = file.head + file.number + file.tail;
            
            answer[i] = filename;
            
        }
        
        
        
        return answer;
    }
}