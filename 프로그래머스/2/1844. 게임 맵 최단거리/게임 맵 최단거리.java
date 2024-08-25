import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int rows = maps.length;  // 맵의 행(row) 길이
        int cols = maps[0].length;  // 맵의 열(column) 길이

        // 상하좌우로 이동하기 위한 방향 벡터
        // {-1, 0} -> 위로 이동, {1, 0} -> 아래로 이동, {0, -1} -> 왼쪽으로 이동, {0, 1} -> 오른쪽으로 이동
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS 탐색을 위한 큐 (queue)
        // 큐에 {현재 행 위치, 현재 열 위치, 현재까지 이동 거리}를 저장
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 시작 위치와 거리(1)를 큐에 삽입

        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            // 큐에서 현재 위치와 이동 거리를 꺼내옴
            int[] current = queue.poll();
            int row = current[0];   // 현재 행 위치
            int col = current[1];   // 현재 열 위치
            int distance = current[2];  // 시작점으로부터의 거리

            // 도착 지점에 도달한 경우, 현재까지의 이동 거리 반환
            if (row == rows - 1 && col == cols - 1) {
                return distance; // 목적지에 도달한 경우 최단거리 반환
            }

            // 4방향(상하좌우)으로 이동하면서 탐색
            for (int[] dir : directions) {
                int newRow = row + dir[0];  // 새로운 행 위치
                int newCol = col + dir[1];  // 새로운 열 위치

                // 새로운 위치가 맵 안에 있고, 이동할 수 있는 칸(값이 1인 칸)인 경우
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maps[newRow][newCol] == 1) {
                    // 해당 위치를 방문 처리 (다시 방문하지 않도록 0으로 변경)
                    maps[newRow][newCol] = 0; 
                    // 큐에 새로운 위치와 이동 거리를 삽입
                    queue.offer(new int[]{newRow, newCol, distance + 1});
                }
            }
        }

        // 목적지에 도달하지 못한 경우 -1 반환
        return -1;
    }
}