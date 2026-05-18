class Solution {
    public long solution(String numbers) {
        // 숫자 영단어들을 배열로 미리 준비합니다.
        String[] words = {"zero", "one", "two", "three", "four", 
                          "five", "six", "seven", "eight", "nine"};

        // 각 영단어를 해당하는 숫자로 치환합니다.
        for (int i = 0; i < words.length; i++) {
            numbers = numbers.replace(words[i], String.valueOf(i));
        }

        // 결과는 문자열 형태이므로 숫자로 변환해서 반환 (문제 요구사항에 따라 다름)
        return Long.parseLong(numbers);
    }
}