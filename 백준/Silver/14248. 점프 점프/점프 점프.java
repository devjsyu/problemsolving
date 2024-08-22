import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 돌다리의 돌 개수 입력
        int n = scanner.nextInt();
        // 각 돌에서 점프할 수 있는 거리 입력
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = scanner.nextInt();
        }

        // 출발점 입력
        int s = scanner.nextInt() - 1; // 입력은 1부터 시작하므로 인덱스를 0부터 시작하도록 조정

        // 방문 여부를 체크할 배열
        boolean[] visited = new boolean[n];

        // BFS를 위한 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;

        // 방문 가능한 돌의 개수를 저장하는 변수
        int count = 0;

        // BFS 시작
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            // 왼쪽으로 점프
            int left = current - stones[current];
            if (left >= 0 && !visited[left]) {
                queue.offer(left);
                visited[left] = true;
            }

            // 오른쪽으로 점프
            int right = current + stones[current];
            if (right < n && !visited[right]) {
                queue.offer(right);
                visited[right] = true;
            }
        }

        // 방문 가능한 돌들의 개수 출력
        System.out.println(count);

        scanner.close();
    }
}
