import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 논문의 인용 횟수를 오름차순으로 정렬
        Arrays.sort(citations);
        
        int n = citations.length;
        int hIndex = 0;

        // 인용 횟수 배열을 순회하면서 H-Index를 계산
        for (int i = 0; i < n; i++) {
            // 현재 논문의 인용 횟수
            int citationsCount = citations[i];

            // 남은 논문의 수 (현재 논문 포함)
            int remainingPapers = n - i;

            // 현재 논문의 인용 횟수가 남은 논문 수 이상이면 H-Index 후보
            if (citationsCount >= remainingPapers) {
                hIndex = remainingPapers;
                break;
            }
        }

        return hIndex;
    }
}
