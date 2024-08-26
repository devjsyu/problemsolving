import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 인접 리스트를 사용하여 그래프를 표현합니다.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        // wires 배열을 순회하며 그래프를 생성합니다.
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        // 각 전선을 끊어서 두 네트워크의 노드 개수 차이를 계산합니다.
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 일시적으로 그래프에서 전선을 제거합니다.
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            // BFS 또는 DFS를 사용하여 하나의 네트워크의 노드 개수를 계산합니다.
            int count1 = bfs(graph, v1, n);
            int count2 = n - count1;  // 전체 노드에서 count1을 빼면 다른 네트워크의 노드 개수가 나옵니다.
            
            // 두 네트워크의 차이의 최소값을 구합니다.
            answer = Math.min(answer, Math.abs(count1 - count2));
            
            // 제거한 전선을 다시 복구합니다.
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return answer;
    }
    
    // BFS를 사용하여 연결된 송전탑의 개수를 계산합니다.
    private int bfs(Map<Integer, List<Integer>> graph, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return count;
    }
}
