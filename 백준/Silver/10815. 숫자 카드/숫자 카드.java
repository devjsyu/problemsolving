import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄: 상근이가 가지고 있는 숫자 카드의 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // 둘째 줄: 숫자 카드에 적혀있는 N개의 정수
        String[] cardStrings = br.readLine().split(" ");
        Set<Integer> cardSet = new HashSet<>();
        
        for (String card : cardStrings) {
            cardSet.add(Integer.parseInt(card));
        }
        
        // 셋째 줄: 찾아야 할 수의 개수 M
        int M = Integer.parseInt(br.readLine());
        
        // 넷째 줄: M개의 정수
        String[] queryStrings = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (String query : queryStrings) {
            int num = Integer.parseInt(query);
            // 카드가 있으면 1, 없으면 0을 결과에 추가
            if (cardSet.contains(num)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        
        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
