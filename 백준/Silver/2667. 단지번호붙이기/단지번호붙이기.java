import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};  // 상하
    static int[] dy = {0, 0, -1, 1};  // 좌우
    
    // 깊이 우선 탐색 함수
    public static int dfs(int x, int y) {
        map[x][y] = 0;  // 방문 처리 (1 -> 0)
        int count = 1;  // 현재 위치 포함한 시작 크기
        
        // 4방향으로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 범위 체크와 방문할 수 있는지 확인
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                count += dfs(nx, ny);  // 재귀 호출로 연결된 1의 개수 추가
            }
        }
        
        return count;  // 전체 연결된 1의 개수 반환
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());  // 지도 크기 입력
        map = new int[N][N];
        
        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> sizes = new ArrayList<>();  // 각 덩어리 크기 저장
        int totalComponents = 0;  // 덩어리 수
        
        // 모든 좌표 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {  // 새로운 덩어리 발견
                    sizes.add(dfs(i, j));
                    totalComponents++;
                }
            }
        }
        
        // 결과 출력
        Collections.sort(sizes);  // 오름차순 정렬
        System.out.println(totalComponents);
        for (int size : sizes) {
            System.out.println(size);
        }
    }
}
