class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 결과를 담을 배열을 targets의 길이만큼 초기화
        int[] answer = new int[targets.length];
        
        // 각 문자의 최소 누름 횟수를 저장할 map 배열을 초기화 (알파벳 개수 26개)
        int[] minPressCount = new int[26];
        
        // minPressCount를 큰 값으로 초기화 (최소값을 찾기 위한 초기 값 설정)
        for (int i = 0; i < 26; i++) {
            minPressCount[i] = Integer.MAX_VALUE;
        }

        // keymap을 순회하면서 각 키에 대한 문자별 최소 누름 횟수 저장
        for (int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            // 해당 키의 문자들을 순차적으로 누르는 경우에 대한 최소 횟수 계산
            for (int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                // 알파벳의 index는 'A'를 기준으로 0부터 시작하므로 변환
                int index = c - 'A';
                // 현재 key의 j번째 문자를 누를 때, 최소 누름 횟수를 저장
                minPressCount[index] = Math.min(minPressCount[index], j + 1);
            }
        }

        // 각 target 문자열에 대해 최소 누름 횟수를 계산
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPressCount = 0;
            boolean isPossible = true;

            // target의 각 문자가 자판에서 가능한지 확인하고, 가능하다면 최소 누름 횟수를 합산
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                int index = c - 'A';

                // 해당 문자가 자판에서 입력 가능한 경우
                if (minPressCount[index] != Integer.MAX_VALUE) {
                    totalPressCount += minPressCount[index];
                } else {
                    // 해당 문자가 자판에서 입력 불가능하면 -1을 저장하고 종료
                    isPossible = false;
                    break;
                }
            }

            // 만약 작성할 수 없는 문자열이라면 -1 저장, 그렇지 않으면 누름 횟수 저장
            if (isPossible) {
                answer[i] = totalPressCount;
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }
}
