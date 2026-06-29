class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        int coupon = chicken; 
        
        // 쿠폰이 10장 이상 모일 때마다 계속 치킨으로 교환
        while (coupon >= 10) {
            int newChicken = coupon / 10; 
            answer += newChicken;        
            
            // (남은 자투리 쿠폰) + (서비스 치킨으로 새로 나온 쿠폰)
            coupon = (coupon % 10) + newChicken; 
        }
        
        return answer;
    }
}