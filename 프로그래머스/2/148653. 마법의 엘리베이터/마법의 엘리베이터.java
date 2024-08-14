class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int currentDigit = storey % 10;  // 현재 자릿수 계산
            int nextDigit = (storey / 10) % 10;  // 다음 자릿수 계산

            // 현재 자릿수가 5보다 크거나, 5이고 다음 자릿수가 5 이상인 경우
            if (currentDigit > 5 || (currentDigit == 5 && nextDigit >= 5)) {
                answer += (10 - currentDigit);  // 10에서 현재 자릿수를 뺀 값을 추가
                storey += (10 - currentDigit);  // 다음 자리로 넘어가기 위해 자릿수를 올림
            } else {
                answer += currentDigit;  // 현재 자릿수만큼만 더함
            }

            storey /= 10;  // 다음 자릿수로 이동
        }

        return answer;
    }
}
