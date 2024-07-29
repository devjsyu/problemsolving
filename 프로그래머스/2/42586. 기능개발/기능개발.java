import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 기능의 배포까지 걸리는 일 수를 저장할 리스트
        List<Integer> days = new ArrayList<>();
        
        // 각 기능의 남은 일수를 계산하여 days 리스트에 추가
        for (int i = 0; i < progresses.length; i++) {
            int remainingWork = 100 - progresses[i];
            int day = (int) Math.ceil((double) remainingWork / speeds[i]);
            days.add(day);
        }
        
        // 각 배포마다 몇 개의 기능이 배포되는지를 저장할 리스트
        List<Integer> deployCounts = new ArrayList<>();
        
        // 첫 번째 기능의 배포 일 수
        int deployDay = days.get(0);
        int count = 1;
        
        // 두 번째 기능부터 순차적으로 검사
        for (int i = 1; i < days.size(); i++) {
            // 현재 기능이 이전 기능보다 늦게 배포되면 배포 일 수 갱신 및 배포 카운트 초기화
            if (days.get(i) > deployDay) {
                deployCounts.add(count);
                deployDay = days.get(i);
                count = 1;
            } else {
                // 그렇지 않으면 같은 배포 일 수에 포함
                count++;
            }
        }
        
        // 마지막 배포에 대한 카운트를 추가
        deployCounts.add(count);
        
        // 결과를 배열로 변환하여 반환
        int[] answer = new int[deployCounts.size()];
        for (int i = 0; i < deployCounts.size(); i++) {
            answer[i] = deployCounts.get(i);
        }
        
        return answer;
    }
}
