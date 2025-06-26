import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지별 집계 결과를 인덱스에 저장하기 위해 N 길이의 배열 생성
        int[] count = new int[N];
        int total = stages.length;

        // stages 배열에 대해 집계 결과 count 배열의 인덱스에 저장
        for (int i = 0; i < total; i++) {
            int index = stages[i];
            if (index <= N) {
                count[index - 1]++;
            }
        }

        // 스테이지별 실패율 계산 위해 2차원 배열 생성
        double[][] failureRate = new double[N][2];

        // 스테이지별 집계한 count 배열으로 스테이지별 실패율 계산
        int challenged = total;
        for (int i = 0; i < N; i++) {
            failureRate[i][0] = i + 1;
            if (challenged == 0) {
                failureRate[i][1] = 0;
            } else {
                failureRate[i][1] = (double) count[i] / challenged;
            }
            challenged -= count[i]; // 실패자 수만큼 줄이기
        }

        // 스테이지별 실패율 배열 정렬하기
        Arrays.sort(failureRate, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                // 실패율 동일할 경우 작은 스테이지가 먼저 나오도록 정렬
                if (o1[1] == o2[1]) {
                    return Double.compare(o1[0], o2[0]);
                } else {
                    // 그외의 경우, 실패율이 높은 순서대로 내림차순 정렬
                    return Double.compare(o2[1], o1[1]);
                }
            }
        });

        // 정답을 배열에 담아 반환하기
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failureRate[i][0];
        }
        return answer;
    }
}

