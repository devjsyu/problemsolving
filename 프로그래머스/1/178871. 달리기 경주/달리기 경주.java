import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수의 이름을 key, 현재 등수를 value로 저장하는 HashMap
        Map<String, Integer> playerRankMap = new HashMap<>();
        
        // 초기 선수들의 순위 정보를 해시맵에 저장
        for (int i = 0; i < players.length; i++) {
            playerRankMap.put(players[i], i);
        }

        // callings 배열을 순회하며 순위 변경 작업 수행
        for (String calling : callings) {
            // 호출된 선수의 현재 등수를 가져옴
            int currentRank = playerRankMap.get(calling);

            // 현재 등수에서 바로 앞에 있는 선수를 추월하는 작업
            if (currentRank > 0) { // 1등은 추월할 수 없으므로, currentRank > 0인 경우만 처리
                String frontPlayer = players[currentRank - 1];  // 앞에 있는 선수의 이름을 가져옴
                
                // 두 선수의 순위를 바꿈 (배열에서)
                players[currentRank] = frontPlayer;
                players[currentRank - 1] = calling;
                
                // 해시맵에서 두 선수의 순위 정보도 업데이트
                playerRankMap.put(calling, currentRank - 1);
                playerRankMap.put(frontPlayer, currentRank);
            }
        }

        // 경주가 끝난 후, 최종 선수 배열을 반환
        return players;
    }
}
