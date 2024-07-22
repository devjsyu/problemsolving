class Solution {
    public int[] solution(int n, long left, long right) {
        // 결과 배열의 크기를 설정합니다.
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        
        // left부터 right까지 각 인덱스에 대해 값을 계산합니다.
        for (long idx = left; idx <= right; idx++) {
            // 1차원 배열의 인덱스 idx를 2차원 배열의 인덱스 (i, j)로 변환합니다.
            int row = (int)(idx / n);
            int col = (int)(idx % n);
            // (i, j)의 값을 계산하여 결과 배열에 저장합니다.
            answer[(int)(idx - left)] = Math.max(row, col) + 1;
        }
        
        return answer;
    }
}
