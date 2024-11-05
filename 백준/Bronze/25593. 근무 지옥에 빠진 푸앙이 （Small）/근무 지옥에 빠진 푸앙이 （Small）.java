import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {

        // 각 근무자의 근무 시간을 저장할 HashMap 생성
        HashMap<String, Integer> workMap = new HashMap<>();

        // BufferedReader를 사용하여 입력 처리 (효율적인 입력을 위해 사용)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine()); // 첫 번째 줄: 주의 개수 입력 받기

        // 주의 개수(count)만큼 반복
        for (int i = 0; i < count; i++) {
            // 각 주는 4일치 근무 데이터가 주어짐
            for (int j = 1; j <= 4; j++) {
                String[] week = br.readLine().split(" "); // 각 줄의 데이터 (근무자 이름들)를 공백으로 분리

                // week 배열의 각 원소(근무자 이름 또는 '-')에 대해 처리
                for (String day : week) {
                    if (!"-".equals(day)) { // '-'가 아닌 실제 근무자가 있는 경우에만 처리
                        int hours = 0; // 근무 시간 초기화
                        if (j == 1) hours = 4;    // 첫 번째 시간대는 08:00~12:00로 4시간
                        if (j == 2) hours = 6;    // 두 번째 시간대는 12:00~18:00로 6시간
                        if (j == 3) hours = 4;    // 세 번째 시간대는 18:00~22:00로 4시간
                        if (j == 4) hours = 10;   // 네 번째 시간대는 22:00~08:00로 10시간

                        // 근무자의 이름을 키로 사용하여 기존 근무 시간에 새로 추가된 시간을 누적
                        workMap.put(day, workMap.getOrDefault(day, 0) + hours);
                    }
                }
            }
        }

        // 입력이 끝났으므로 BufferedReader 닫기
        br.close();

        // 최소 및 최대 근무 시간을 찾기 위한 초기값 설정
        int min = 3500, max = 0;

        // 모든 근무자에 대해 근무 시간을 순회하며 최대/최소 근무 시간 계산
        for (Entry<String, Integer> entry : workMap.entrySet()) {
            int value = entry.getValue();
            if (min > value) min = value;  // 현재 값이 최소보다 작으면 min 갱신
            if (max < value) max = value;  // 현재 값이 최대보다 크면 max 갱신
        }

        // BufferedWriter를 사용하여 결과 출력 (효율적인 출력을 위해 사용)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 최대 근무 시간과 최소 근무 시간의 차이가 12시간 이하인지 확인 후 "Yes" 또는 "No" 출력
        bw.write((max - min <= 12) ? "Yes" : "No");

        // 출력 후 flush() 및 BufferedWriter 닫기
        bw.flush();
        bw.close();
    }
}
