import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int k;
    static char[] operators;
    static boolean[] used = new boolean[10]; // 숫자 사용 여부 체크
    static List<String> results = new ArrayList<>(); // 가능한 결과들을 저장할 리스트

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        k = scanner.nextInt();
        operators = new char[k];
        for (int i = 0; i < k; i++) {
            operators[i] = scanner.next().charAt(0);
        }

        // 백트래킹을 사용해 숫자 조합 찾기
        backtrack("", 0);

        // 결과 리스트를 정렬하여 최대값과 최소값 출력
        Collections.sort(results);
        System.out.println(results.get(results.size() - 1)); // 최대값
        System.out.println(results.get(0)); // 최소값
    }

    // 백트래킹 함수
    static void backtrack(String number, int index) {
        // 숫자 조합이 완성된 경우
        if (index == k + 1) {
            results.add(number); // 결과 리스트에 추가
            return;
        }

        // 0부터 9까지의 숫자 시도
        for (int i = 0; i <= 9; i++) {
            if (used[i]) continue; // 이미 사용된 숫자는 건너뛰기

            // 현재 단계에서 숫자를 추가해도 부등호를 만족하는지 확인
            if (index == 0 || checkCondition(number.charAt(index - 1) - '0', i, operators[index - 1])) {
                used[i] = true; // 숫자 사용 체크
                backtrack(number + i, index + 1); // 다음 단계로 이동
                used[i] = false; // 숫자 사용 해제
            }
        }
    }

    // 부등호 조건을 확인하는 함수
    static boolean checkCondition(int a, int b, char op) {
        if (op == '<') return a < b;
        if (op == '>') return a > b;
        return false;
    }
}
