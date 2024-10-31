class Solution {
    public int solution(String s) {
        // 0부터 9까지의 숫자와 그에 대응하는 영단어를 배열에 저장합니다.
        String[] numWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // 각 영단어를 숫자로 대체하기 위해 반복문을 돌립니다.
        for (int i = 0; i < numWords.length; i++) {
            // s가 현재 영단어(numWords[i])를 포함하고 있는 동안 계속 반복합니다.
            if (s.contains(numWords[i])) {
                // 해당 영단어를 해당 숫자로 대체합니다.
                s = s.replace(numWords[i], String.valueOf(i));
            }
        }
        
        // 모든 영단어가 숫자로 변환된 후, 문자열을 정수로 변환하여 반환합니다.
        int answer = Integer.parseInt(s);
        return answer;
    }
}
