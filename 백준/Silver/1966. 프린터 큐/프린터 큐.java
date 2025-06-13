import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // 전체 반복 횟수 입력 받기
            int total = Integer.parseInt(reader.readLine());

            // 결과 저장 및 효율적인 출력을 위한 StringBuilder 클래스 인스턴스화
            StringBuilder sb = new StringBuilder();

            // for-loop : 입력 받은 후 커스텀 프린터 큐 결과값 저장하기
            for (int j = 0; j < total; j++) {
                // 입력으로부터 변수 초기화
                // BufferedReader와 StringTokenizer 클래스로 빠르게 입력 받기
                StringTokenizer input1st = new StringTokenizer(reader.readLine());
                StringTokenizer input2nd = new StringTokenizer(reader.readLine());
                int length = Integer.parseInt(input1st.nextToken());
                int targetIndex = Integer.parseInt(input1st.nextToken());

                // 큐 생성
                Queue<Document> queue = new LinkedList<>();

                // 우선순위 저장 배열 생성
                int[] priorities = new int[10];

                // 인덱스, 우선순위 속성 담긴 객체 큐에 저장
                // 우선순위 배열에 저장
                for (int i = 0; i < length; i++) {
                    int priority = Integer.parseInt(input2nd.nextToken());
                    queue.offer(new Document(i, priority));
                    priorities[priority]++;
                }

                // 출력 순서 저장할 변수
                int printOrder = 0;
                while (!queue.isEmpty()) {
                    // 현재 가장 앞 원소 poll
                    Document current = queue.poll();
                    // poll 할 때마다 더 우선순위 높은 것이 있는지 여부 변수 초기화
                    boolean hasHigherPriority = false;

                    // 현재 문서의 우선순위보다 높은 경우가 있는지 검사
                    for (int i = 10 - 1; i > current.priority; i--) {
                        if (priorities[i] > 0) {
                            // 우선순위 더 높은 경우 있다면, true로 갱신
                            hasHigherPriority = true;
                            break;
                        }
                    }
                    // 우선순위 검사 이후 실행
                    if (hasHigherPriority) {
                        // 현재 문서를 큐 가장 뒷 줄로 보내기
                        queue.offer(current);
                    } else {
                        // 출력된 우선순위 제거하기
                        priorities[current.priority]--;
                        // 출력 순서 갱신
                        printOrder++;

                        // 문제에서 요구하는 인덱스일 경우
                        if (targetIndex == current.index) {
                            // 결과값 저장
                            sb.append(printOrder).append("\n");
                            break;
                        }
                    }
                }
            }

            // 결과 출력
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 커스텀 클래스
    private static class Document {
        private int index;
        private int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
