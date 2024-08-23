import java.util.*;

class Solution {
    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        int[] start = new int[2];
        int[] goal = new int[2];
        
        // 로봇의 시작 위치(R)와 목표 위치(G)를 찾음
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i].charAt(j) == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        // BFS를 위한 큐와 방문 체크 배열 초기화
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.add(new int[]{start[0], start[1], 0}); // {행, 열, 이동 횟수}
        visited[start[0]][start[1]] = true;
        
        // 상하좌우 방향 벡터
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int moves = current[2];
            
            // 목표 위치에 도달한 경우
            if (currentRow == goal[0] && currentCol == goal[1]) {
                return moves;
            }
            
            // 4가지 방향으로 이동 시도
            for (int i = 0; i < 4; i++) {
                int newRow = currentRow;
                int newCol = currentCol;
                
                // 해당 방향으로 이동할 수 있을 때까지 이동
                while (true) {
                    int nextRow = newRow + dRow[i];
                    int nextCol = newCol + dCol[i];
                    
                    // 경계를 넘거나 장애물을 만나면 멈춤
                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || board[nextRow].charAt(nextCol) == 'D') {
                        break;
                    }
                    
                    newRow = nextRow;
                    newCol = nextCol;
                }
                
                // 새로운 위치가 방문되지 않은 곳이라면 큐에 추가
                if (!visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, moves + 1});
                }
            }
        }
        
        // 목표 위치에 도달할 수 없는 경우
        return -1;
    }
}
