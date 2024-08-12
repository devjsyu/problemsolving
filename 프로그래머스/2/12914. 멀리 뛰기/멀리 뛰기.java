class Solution {
    public long solution(int n) {
        // 피보나치 수열의 값을 저장하기 위한 배열
        long[] dp = new long[n + 1];

        // 초기값 설정
        dp[1] = 1; // 1칸일 때는 1가지 방법만 가능
        if (n > 1) {
            dp[2] = 2; // 2칸일 때는 2가지 방법이 가능 (1칸+1칸, 2칸)
        }

        // 피보나치 수열을 사용하여 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        // 결과 반환
        return dp[n];
    }
}
