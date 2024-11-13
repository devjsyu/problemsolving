import java.io.*;
import java.util.*;

public class Main {
    // Queue와 List를 정적 변수로 선언하여 사용할 수 있도록 합니다.
    static Queue<Integer> q;     // 카드 저장을 위한 큐
    static List<Integer> list;   // 버려진 카드의 순서를 저장할 리스트

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 카드 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 큐와 리스트를 초기화
        q = new LinkedList<>();
        list = new ArrayList<>();

        // 1부터 N까지의 숫자를 큐에 추가하여 카드 더미 생성
        for (int i = 1; i <= N; i++) {
            q.add(i);      // 예를 들어 N이 4라면 큐는 1, 2, 3, 4 순서로 쌓임
        }

        // 큐가 비어 있을 때까지 반복
        while (!q.isEmpty()) {
            // 1. 제일 위의 카드를 버리고 리스트에 추가
            list.add(q.poll()); // 큐에서 맨 앞의 카드를 제거하고 리스트에 추가

            // 2. 큐의 제일 위 카드를 맨 아래로 이동
            if (q.peek() != null) { // 큐에 남은 카드가 있는 경우
                Integer T = q.poll(); // 제일 위 카드를 제거하고
                q.add(T); // 제거한 카드를 큐의 맨 아래로 추가
            }
        }

        // 결과 출력: 버린 카드의 순서대로 출력
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
