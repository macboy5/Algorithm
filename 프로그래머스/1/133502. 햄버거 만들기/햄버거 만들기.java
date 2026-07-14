import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> main = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        
        // 1 빵, 2 야채, 3 고기
        
        // 1 2 3 1 순
        
        for(int i : ingredient){
            main.push(i);
            
            // main의 맨위가 1일 경우 꺼내면서 만들수있는지검사.
            if(main.peek() == 1 && main.size()>=4){
                tmp.push(1);
                main.pop();
                
               
                while(!main.isEmpty()){
                    int top_main = main.peek();
                    int top_tmp = tmp.peek();
                    
                    // 햄버거 만드는 과정
                    if(top_tmp == 1 && top_main == 3 ||
                      top_tmp==3 && top_main == 2 
                      ){
                        tmp.push(top_main);
                        main.pop();
                    }
                    else if(top_tmp == 2 && top_main == 1){
                        // 햄버거 완성
                        main.pop();
                        while(!tmp.isEmpty()){
                            tmp.pop();
                        }
                        answer++;
                        break;
                    }
                    else{
                        //  만들 수 없는 경우 : tmp에 있던 것 main으로 옮기기
                        while(!tmp.isEmpty()){
                            main.push(tmp.peek());
                            tmp.pop();
                        }
                        
                        break;
                        
                    }
                
                }
                
                
            }
            
        }
        
        
        
        return answer;
    }
}