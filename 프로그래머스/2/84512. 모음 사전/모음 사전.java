class Solution {
    public int solution(String word) {
        // 각 자리에서 가질 수 있는 조합의 수
        int[] multipliers = {781, 156, 31, 6, 1};
        // 알파벳 모음 배열
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        
        int answer = word.length(); // 단어 자체의 길이를 더함
        
        for (int i = 0; i < word.length(); i++) {
            // 현재 자리의 알파벳이 vowels 배열에서 몇 번째인지 찾음
            for (int j = 0; j < vowels.length; j++) {
                if (word.charAt(i) == vowels[j]) {
                    answer += j * multipliers[i];
                    break;
                }
            }
        }
        
        return answer;
    }
}
