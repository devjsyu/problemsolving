import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 결과로 반환할 가능한 회원가입 날짜의 수
        int answer = 0;
        
        // 원하는 제품과 해당 제품의 수량을 저장하는 해시맵 생성
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        // want 배열과 number 배열을 통해 해시맵 초기화
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // discount 배열에서 10일씩 묶어서 슬라이딩 윈도우 방식으로 확인
        for (int i = 0; i <= discount.length - 10; i++) {
            // 현재 10일간의 제품 수를 저장할 해시맵 생성
            HashMap<String, Integer> discountMap = new HashMap<>();
            
            // 10일 동안의 제품을 카운트해서 discountMap에 저장
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            // 원하는 제품과 현재 할인 제품이 일치하는지 확인
            boolean isMatch = true;
            for (String key : wantMap.keySet()) {
                // 원하는 제품이 현재 할인 제품의 수량과 일치하지 않으면 불일치 처리
                if (discountMap.getOrDefault(key, 0) < wantMap.get(key)) {
                    isMatch = false;
                    break;
                }
            }

            // 모든 제품과 수량이 일치하면 가능한 회원가입 날짜로 카운트
            if (isMatch) {
                answer++;
            }
        }

        // 결과 반환
        return answer;
    }
}
