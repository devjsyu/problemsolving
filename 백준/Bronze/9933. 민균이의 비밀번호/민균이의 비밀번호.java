import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 빠르게 입력을 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 단어의 수 N을 정수로 입력받음
        int n = Integer.parseInt(br.readLine());

        // 중복을 제거하면서 빠른 검색을 위해 HashSet을 사용하여 단어를 저장할 Set 생성
        Set<String> set = new HashSet<>();

        // 단어의 개수만큼 반복하여 단어를 입력받고, 비밀번호인지 검사
        for (int i = 0; i < n; i++) {
            // 한 줄에 하나씩 단어를 입력받음
            String s = br.readLine();

            // 입력받은 단어를 Set에 추가하여 중복 단어를 방지
            set.add(s);

            // StringBuilder를 사용해 현재 단어 s를 뒤집음
            StringBuilder sb = new StringBuilder(s);
            String reverse = sb.reverse().toString(); // 뒤집은 문자열 생성

            // 현재 단어의 뒤집은 문자열이 이미 Set에 존재하는지 확인
            if (set.contains(reverse)) {
                // 조건을 만족하면 이 단어가 비밀번호임을 의미
                // 비밀번호의 길이와 가운데 글자를 출력
                System.out.println(reverse.length() + " " + reverse.charAt(reverse.length() / 2));
                
                // 답이 유일하기 때문에 비밀번호를 찾은 후에는 반복문 종료
                break;
            }
        }
    }
}
