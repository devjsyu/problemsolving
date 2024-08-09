import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 사람들의 몸무게 배열을 정렬합니다.
        Arrays.sort(people);
        
        int answer = 0; // 필요한 구명보트의 개수를 세기 위한 변수
        int light = 0;  // 가장 가벼운 사람의 인덱스
        int heavy = people.length - 1; // 가장 무거운 사람의 인덱스
        
        // 가장 가벼운 사람과 가장 무거운 사람을 짝지어서 보트를 탑니다.
        while (light <= heavy) {
            // 두 사람의 몸무게 합이 제한을 넘지 않으면 같이 태웁니다.
            if (people[light] + people[heavy] <= limit) {
                light++;
                heavy--;
            } else {
                // 그렇지 않으면 무거운 사람만 태우고 보트를 하나 씁니다.
                heavy--;
            }
            // 보트 하나 사용
            answer++;
        }
        
        return answer;
    }
}
