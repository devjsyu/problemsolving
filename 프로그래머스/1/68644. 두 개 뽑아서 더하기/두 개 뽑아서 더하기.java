import java.util.*;

class Solution {
    public static int[] solution(int[] numbers) {
        // 중복값 배제를 위한 해시셋
        Set<Integer> set = new HashSet<>();

        // 해시셋에 값 저장
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        // 해시셋 중복값 제거 및 오름차순 정렬 후 int 배열로 변환
        return set.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }
}