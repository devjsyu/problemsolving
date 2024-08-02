class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 각 카드 뭉치의 인덱스를 초기화
        int index1 = 0;
        int index2 = 0;
        
        // 목표 배열의 각 단어를 순차적으로 확인
        for (String word : goal) {
            // 현재 단어가 첫 번째 카드 뭉치에서 사용 가능하다면
            if (index1 < cards1.length && cards1[index1].equals(word)) {
                index1++;  // 첫 번째 카드 뭉치의 인덱스를 증가
            }
            // 현재 단어가 두 번째 카드 뭉치에서 사용 가능하다면
            else if (index2 < cards2.length && cards2[index2].equals(word)) {
                index2++;  // 두 번째 카드 뭉치의 인덱스를 증가
            }
            // 현재 단어를 어떤 카드 뭉치에서도 사용할 수 없다면
            else {
                return "No";  // 목표 배열을 만들 수 없으므로 "No"를 반환
            }
        }
        
        // 모든 단어를 순차적으로 사용 가능하다면 "Yes"를 반환
        return "Yes";
    }
}
