import java.util.*;

class Solution {
    // 지도 상의 한 칸을 방문했는지를 체크하기 위한 배열
    private boolean[][] visited;
    private int rows, cols;

    // 방향 벡터 상하좌우
    private int[] dRow = {-1, 1, 0, 0};
    private int[] dCol = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        // 지도의 행과 열 크기
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];

        // 각 무인도에서 머물 수 있는 날을 저장할 리스트
        List<Integer> stayDays = new ArrayList<>();

        // 모든 칸을 확인
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 숫자이고 아직 방문하지 않은 칸이면 DFS 탐색 시작
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int days = dfs(maps, i, j);
                    stayDays.add(days);
                }
            }
        }

        // 무인도에서 머물 수 있는 날을 오름차순으로 정렬
        if (stayDays.isEmpty()) {
            return new int[]{-1}; // 무인도가 없다면 -1 반환
        } else {
            Collections.sort(stayDays);
            return stayDays.stream().mapToInt(i -> i).toArray();
        }
    }

    // DFS를 이용하여 무인도를 탐색하며 총 식량(머무를 수 있는 날)을 계산
    private int dfs(String[] maps, int row, int col) {
        visited[row][col] = true; // 현재 칸을 방문 처리
        int food = Character.getNumericValue(maps[row].charAt(col)); // 현재 칸의 식량

        // 상하좌우로 연결된 모든 칸을 탐색
        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            // 새 위치가 지도 내에 있고, 아직 방문하지 않았으며, 숫자라면 탐색
            if (isValid(newRow, newCol) && !visited[newRow][newCol] && maps[newRow].charAt(newCol) != 'X') {
                food += dfs(maps, newRow, newCol); // 연결된 칸의 식량을 더함
            }
        }

        return food; // 총 식량(머무를 수 있는 날)을 반환
    }

    // 주어진 위치가 지도 내에 있는지 확인하는 메서드
    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
