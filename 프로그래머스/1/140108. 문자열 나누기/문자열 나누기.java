public class Solution {
    public int solution(String s) {
        int count = 0;  // 분리된 문자열 개수를 세는 변수
        int i = 0;  // 현재 위치를 추적하기 위한 인덱스 변수
        
        while (i < s.length()) {
            char x = s.charAt(i);  // 현재 첫 글자 읽기
            int xCount = 0;  // x와 같은 글자의 개수
            int otherCount = 0;  // x가 아닌 다른 글자의 개수
            int j = i;  // 분리를 시작할 위치 설정
            
            // x와 x가 아닌 글자 개수가 같아질 때까지 반복
            while (j < s.length()) {
                if (s.charAt(j) == x) {
                    xCount++;
                } else {
                    otherCount++;
                }
                
                // x와 x가 아닌 글자의 개수가 같아지면 분리
                if (xCount == otherCount) {
                    break;
                }
                
                j++;
            }
            
            // 분리된 문자열 하나가 완성되었으므로 카운트를 증가
            count++;
            
            // 다음 분리를 위해 인덱스 i를 j + 1로 이동
            i = j + 1;
        }
        
        return count;  // 최종 분리된 문자열의 개수를 반환
    }
}
