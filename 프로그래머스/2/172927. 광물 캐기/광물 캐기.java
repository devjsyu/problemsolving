class Solution {
    // 최소 피로도를 저장하는 변수
    private static int min;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 최소 피로도를 매우 큰 값으로 초기화
        min = 987654321;
        int mineralsSize = minerals.length;

        // 깊이 우선 탐색(dfs) 시작
        dfs(picks, minerals, mineralsSize, 0, 0);

        // 최소 피로도 값을 결과로 반환
        answer = min;
        return answer;
    }

    // dfs 메서드: 곡괭이를 사용하여 광물을 채굴하는 모든 경우를 탐색
    public void dfs(int[] picks, String[] minerals, int mineralsSize, int idx, int fatigue) {
        // 기저 조건: 모든 광물을 채굴했거나 곡괭이를 모두 사용했을 때
        if (idx >= mineralsSize || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            // 현재까지의 피로도와 최소 피로도를 비교하여 갱신
            min = Math.min(min, fatigue);
            return;
        }

        // 다이아 곡괭이를 사용하는 경우
        if (picks[0] != 0) {
            int tmp = mining(0, minerals, mineralsSize, idx, fatigue);
            int[] newPicks = {picks[0] - 1, picks[1], picks[2]};
            dfs(newPicks, minerals, mineralsSize, idx + 5, tmp);
        }

        // 철 곡괭이를 사용하는 경우
        if (picks[1] != 0) {
            int tmp = mining(1, minerals, mineralsSize, idx, fatigue);
            int[] newPicks = {picks[0], picks[1] - 1, picks[2]};
            dfs(newPicks, minerals, mineralsSize, idx + 5, tmp);
        }

        // 돌 곡괭이를 사용하는 경우
        if (picks[2] != 0) {
            int tmp = mining(2, minerals, mineralsSize, idx, fatigue);
            int[] newPicks = {picks[0], picks[1], picks[2] - 1};
            dfs(newPicks, minerals, mineralsSize, idx + 5, tmp);
        }
    }

    // mining 메서드: 주어진 곡괭이로 5개의 광물을 채굴하여 피로도를 계산
    public int mining(int pick, String[] minerals, int mineralsSize, int idx, int fatigue) {
        int tmp = 0;
        // 5개의 광물을 채굴하거나 모든 광물을 다 채굴할 때까지 반복
        for (int i = 0; i < 5; i++) {
            if (i + idx < mineralsSize) {
                tmp += calFatigue(pick, minerals[i + idx]);
            } else { // 모든 광물을 다 채굴한 경우 반복 종료
                break;
            }
        }
        return fatigue + tmp; // 기존 피로도에 현재 채굴한 피로도를 더해서 반환
    }

    // calFatigue 메서드: 곡괭이 종류와 광물에 따른 피로도를 계산
    public int calFatigue(int pick, String mineral) {
        if (pick == 0) { // 다이아몬드 곡괭이 사용 시
            return 1;
        } else if (pick == 1) { // 철 곡괭이 사용 시
            if (mineral.equals("diamond")) {
                return 5;
            } else if (mineral.equals("iron")) {
                return 1;
            } else if (mineral.equals("stone")) {
                return 1;
            }
        } else if (pick == 2) { // 돌 곡괭이 사용 시
            if (mineral.equals("diamond")) {
                return 25;
            } else if (mineral.equals("iron")) {
                return 5;
            } else if (mineral.equals("stone")) {
                return 1;
            }
        }
        return 0; // 예외적인 경우 0 반환
    }
}