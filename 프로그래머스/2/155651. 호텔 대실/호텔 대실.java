import java.util.*;

class Solution {
    
    static class Book{
        private int start;
        private int end;
        
        Book(String[] book){
            String[] tmp = book[0].split(":");
            this.start = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
            
            String[] tmp2 = book[1].split(":");
            this.end = Integer.parseInt(tmp2[0])*60 + Integer.parseInt(tmp2[1]) + 10;
            
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<Book> bookList = new ArrayList<>();
        List<Book> roomList = new ArrayList<>();
        
        for(String[] book : book_time){
            bookList.add(new Book(book));
        }
        
        bookList.sort( (b1, b2) -> {
            if(b1.start == b2.start){
                return Integer.compare(b1.end, b2.end);
            }
            else return Integer.compare(b1.start, b2.start);
        });
        

        for(int i=0; i<bookList.size(); i++){
            Book book = bookList.get(i);
            
            if(roomList.isEmpty()){
                roomList.add(book);
            }
            else{
                boolean flag = false;
                
                for(int j=0; j<roomList.size(); j++){
                    Book cur = roomList.get(j);
                    
                    if(cur.end <= book.start){
                        roomList.remove(cur);
                        roomList.add(book);
                        flag = true;
                        break;
                    }
                    
                }
                
                if(!flag){
                    roomList.add(book);
                }
                
            }

            
        }
        
        answer = roomList.size();

        
        
        return answer;
    }
}