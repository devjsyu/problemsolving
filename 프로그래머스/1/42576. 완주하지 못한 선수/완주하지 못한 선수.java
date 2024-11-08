import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 참가자의 이름과 그 수를 저장할 해시맵 생성
        HashMap<String, Integer> participantMap = new HashMap<>();

        // 참가자 배열을 순회하여 각 참가자의 이름과 횟수를 맵에 저장
        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }

        // 완주자 배열을 순회하며 완주한 참가자의 횟수를 감소
        for (String c : completion) {
            participantMap.put(c, participantMap.get(c) - 1);
        }

        // 참가자 해시맵에서 값이 0이 아닌 참가자를 찾아 반환
        for (String key : participantMap.keySet()) {
            if (participantMap.get(key) != 0) {
                return key; // 완주하지 못한 참가자의 이름 반환
            }
        }

        return ""; // 이 부분은 논리적으로 실행되지 않지만 문법적 완전성을 위해 추가
    }
}
