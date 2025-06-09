import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int total = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < total; i++) {
                String line = br.readLine();
                sb.append(isVPS(line)).append('\n');
            }
            bw.write(sb.toString());
        }
    }

    private static String isVPS(String line) {
        int length = line.length();

        // 문자열의 길이가 홀수라면 바로 NO 출력하기
        if (length % 2 != 0) {
            return "NO";
        }

        char[] charArray = line.toCharArray();
        int zeroSum = 0;
        
        // '('일 때 +, ')'일 때 -, zeroSum이 0이 아닌 경우 NO 출력하기
        for (int j = 0; j < length; j++) {
            if (charArray[j] == '(') {
                zeroSum++;
            } else {
                zeroSum--;
            }
            if (zeroSum < 0) {
                return "NO";
            }
        }
        if (zeroSum != 0) {
            return "NO";
        } else {
            return "YES";
        }
    }
}
