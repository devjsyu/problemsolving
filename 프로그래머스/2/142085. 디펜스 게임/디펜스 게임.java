import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 최대 힙을 사용하여 가장 큰 enemy[i] 값을 관리
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0; // 현재까지 소모된 병사의 수

        for (int i = 0; i < enemy.length; i++) {
            // 현재 라운드의 적 수를 힙에 추가
            maxHeap.add(enemy[i]);
            sum += enemy[i]; // 병사 소모

            // 병사 수가 모자랄 경우
            if (sum > n) {
                // 무적권 사용이 가능한 경우
                if (k > 0) {
                    // 가장 큰 적 수를 무적권으로 처리
                    sum -= maxHeap.poll();
                    k--; // 무적권 사용 횟수 감소
                } else {
                    // 더 이상 무적권을 사용할 수 없으면 현재 라운드에서 게임 종료
                    return i;
                }
            }
        }
        // 모든 라운드를 막을 수 있으면 enemy 배열의 길이를 반환
        return enemy.length;
    }
}
