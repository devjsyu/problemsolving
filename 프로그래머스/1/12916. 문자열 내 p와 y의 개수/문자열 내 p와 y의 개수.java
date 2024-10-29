class Solution {
    public boolean solution(String s) {
        // 문자열을 소문자로 변환하여 'P'와 'Y'를 구별 없이 카운팅 가능하게 함
        s = s.toLowerCase();
        
        int pCount = 0; // 'p'의 개수를 저장할 변수
        int yCount = 0; // 'y'의 개수를 저장할 변수
        
        // 문자열의 각 문자를 순회하며 'p'와 'y'의 개수를 세기
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'p') {
                pCount++;
            } else if (ch == 'y') {
                yCount++;
            }
        }
        
        // 'p'의 개수와 'y'의 개수가 같으면 true, 다르면 false 반환
        return pCount == yCount;
    }
}
