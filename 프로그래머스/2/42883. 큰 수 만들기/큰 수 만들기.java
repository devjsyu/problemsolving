class Solution {
    public String solution(String number, int k) {
        // 최종 결과를 저장할 StringBuilder
        StringBuilder answer = new StringBuilder();

        // 현재 만들고자 하는 숫자의 길이
        int length = number.length() - k;

        // 탐색 시작 위치
        int index = 0;

        // length만큼 반복하여 가장 큰 수를 선택
        for (int i = 0; i < length; i++) {
            // 가장 큰 숫자를 저장할 변수
            char max = '0';

            // 탐색 범위: 현재 위치에서부터 남은 자릿수까지
            for (int j = index; j <= k + i; j++) {
                // 현재 위치의 숫자가 가장 크면 max 갱신
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    index = j + 1; // 선택된 숫자의 다음 위치를 탐색 시작 위치로 설정
                }
            }

            // 가장 큰 숫자를 정답에 추가
            answer.append(max);
        }

        // StringBuilder를 문자열로 변환하여 반환
        return answer.toString();
    }
}
