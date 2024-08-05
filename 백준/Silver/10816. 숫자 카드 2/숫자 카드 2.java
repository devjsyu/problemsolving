import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 상근이가 가지고 있는 숫자 카드의 개수 입력
        int N = scanner.nextInt();
        // 숫자 카드에 적혀있는 정수를 저장할 맵 생성
        Map<Integer, Integer> cardCount = new HashMap<>();
        
        // N개의 숫자 카드 입력
        for (int i = 0; i < N; i++) {
            int card = scanner.nextInt();
            // 숫자 카드의 개수를 맵에 저장
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        // 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수 개수 입력
        int M = scanner.nextInt();
        // 결과를 저장할 StringBuilder 생성
        StringBuilder result = new StringBuilder();
        
        // M개의 정수 입력
        for (int i = 0; i < M; i++) {
            int query = scanner.nextInt();
            // 각 정수가 몇 개 있는지 결과에 추가
            result.append(cardCount.getOrDefault(query, 0)).append(" ");
        }
        
        // 결과 출력
        System.out.println(result.toString().trim());
        
        // Scanner 자원 해제
        scanner.close();
    }
}
