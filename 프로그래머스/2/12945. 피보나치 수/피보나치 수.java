class Solution {
    public int solution(int n) {
        // 피보나치 수를 계산하는데 사용할 배열 선언
        int[] fib = new int[n + 1];
        
        // 초기 값 설정
        fib[0] = 0;
        fib[1] = 1;

        // 피보나치 수를 계산하여 배열에 저장
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567; // 중간 계산마다 1234567로 나눈 나머지를 저장
        }

        // n번째 피보나치 수를 반환
        return fib[n];
    }
}
