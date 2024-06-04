class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n]; // 각 학생의 체육복 상태를 나타내는 배열
        int answer = n; // 체육수업을 들을 수 있는 학생 수

        // 도난당한 학생의 체육복 상태를 -1로 설정
        for (int l : lost) 
            people[l-1]--;

        // 여벌 체육복을 가진 학생의 체육복 상태를 +1로 설정
        for (int r : reserve) 
            people[r-1]++;

        // 체육복 상태를 검사하여 빌려줄 수 있는지 확인
        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) { // 체육복이 없는 학생인 경우
                // 앞 번호 학생이 여벌 체육복이 있는 경우
                if (i-1 >= 0 && people[i-1] == 1) {
                    people[i]++; // 체육복을 빌림
                    people[i-1]--; // 여벌 체육복을 빌려준 학생의 체육복 상태 감소
                } 
                // 뒷 번호 학생이 여벌 체육복이 있는 경우
                else if (i+1 < people.length && people[i+1] == 1) {
                    people[i]++; // 체육복을 빌림
                    people[i+1]--; // 여벌 체육복을 빌려준 학생의 체육복 상태 감소
                } 
                // 체육복을 빌릴 수 없는 경우
                else 
                    answer--; // 체육수업을 들을 수 있는 학생 수 감소
            }
        }
        return answer; // 최종 체육수업을 들을 수 있는 학생 수 반환
    }
}
