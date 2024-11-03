import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 정환이 알고 있는 노래의 개수 N과 맞히기를 시도할 노래의 개수 M 입력
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 개행문자 소비

        // 첫 세 음을 키로 하고, 해당하는 노래 제목을 저장할 Map
        Map<String, String> songMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>(); // 키와 매칭되는 노래 수 저장

        // 노래 목록 저장
        for (int i = 0; i < N; i++) {
            int T = scanner.nextInt();  // 노래 제목의 길이
            String title = scanner.next();  // 노래 제목
            String firstSevenNotes = "";

            // 첫 7개의 음을 하나의 문자열로 저장
            for (int j = 0; j < 7; j++) {
                firstSevenNotes += scanner.next();
            }
            
            // 첫 세 음 추출
            String firstThreeNotes = firstSevenNotes.substring(0, 3);

            // Map에 첫 세 음에 해당하는 노래 제목 저장
            if (!songMap.containsKey(firstThreeNotes)) {
                songMap.put(firstThreeNotes, title);
                countMap.put(firstThreeNotes, 1);
            } else {
                // 같은 첫 세 음이 이미 있으면 카운트 증가
                countMap.put(firstThreeNotes, countMap.get(firstThreeNotes) + 1);
            }
        }

        // 맞히기를 시도하는 각 노래 처리
        for (int i = 0; i < M; i++) {
            // 첫 세 음 입력받기
            String attemptNotes = scanner.next() + scanner.next() + scanner.next();

            // 첫 세 음에 해당하는 노래 제목 출력
            if (!songMap.containsKey(attemptNotes)) {
                System.out.println("!");
            } else if (countMap.get(attemptNotes) > 1) {
                System.out.println("?");
            } else {
                System.out.println(songMap.get(attemptNotes));
            }
        }

        scanner.close();
    }
}
