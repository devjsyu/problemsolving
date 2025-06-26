import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int student1Cycle = student1.length;

        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int student2Cycle = student2.length;

        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int student3Cycle = student3.length;

        int[] answerMatchCount = new int[3];

        for (int i = 0; i < answers.length; i++) {
            // 수포자 1이 찍은 답안 매칭
            int index = i % student1Cycle;
            if (answers[i] == student1[index]) {
                answerMatchCount[0]++;
            }

            // 수포자 2이 찍은 답안 매칭
            index = i % student2Cycle;
            if (answers[i] == student2[index]) {
                answerMatchCount[1]++;
            }

            // 수포자 3이 찍은 답안 매칭
            index = i % student3Cycle;
            if (answers[i] == student3[index]) {
                answerMatchCount[2]++;
            }
        }

        // 정답 개수 최대값 찾기
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (answerMatchCount[i] > max) {
                max = answerMatchCount[i];
            }
        }

        // 최다 득점자를 오름차순으로 배열에 담아 반환하기
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == answerMatchCount[i]) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}