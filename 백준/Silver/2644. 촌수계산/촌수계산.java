import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 전체 사람 수 입력
        int n = sc.nextInt();

        // 촌수를 계산해야 하는 두 사람의 번호 입력
        int person1 = sc.nextInt();
        int person2 = sc.nextInt();

        // 부모 자식 관계의 개수 입력
        int m = sc.nextInt();

        // 인접 리스트로 그래프 표현
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 부모 자식 관계 입력
        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            graph[parent].add(child);
            graph[child].add(parent);
        }

        // BFS를 사용하여 촌수 계산
        int result = calculateKinship(graph, n, person1, person2);
        System.out.println(result);
        
        sc.close();
    }

    // BFS를 사용하여 두 사람의 촌수를 계산하는 함수
    public static int calculateKinship(List<Integer>[] graph, int n, int start, int end) {
        // 방문 여부를 저장하는 배열
        boolean[] visited = new boolean[n + 1];
        // 촌수를 저장하는 배열
        int[] distance = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);

                    // 목표 지점에 도달하면 촌수를 반환
                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }

        // 연결되지 않은 경우 -1 반환
        return -1;
    }
}
