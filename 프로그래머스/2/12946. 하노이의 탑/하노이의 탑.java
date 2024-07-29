import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        hanoi(n, 1, 3, 2, moves);  // n개의 원판을 1번 기둥에서 3번 기둥으로 이동
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        return answer;
    }

    // 하노이 탑 재귀적 해결 방법
    private void hanoi(int n, int from, int to, int via, List<int[]> moves) {
        if (n == 1) {
            moves.add(new int[]{from, to});  // 하나의 원판을 from에서 to로 이동
        } else {
            hanoi(n - 1, from, via, to, moves);  // n-1개의 원판을 from에서 via로 이동
            moves.add(new int[]{from, to});  // 가장 큰 원판을 from에서 to로 이동
            hanoi(n - 1, via, to, from, moves);  // n-1개의 원판을 via에서 to로 이동
        }
    }
}
