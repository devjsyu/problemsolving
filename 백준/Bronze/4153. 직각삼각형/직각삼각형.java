import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        // while loop
        while (true) {
            // 입력 받기
            String input = scanner.nextLine();

            // break condition
            if (input.equals("0 0 0")) break;

            // 문자열을 각 세 개 숫자로 파싱하기
            StringTokenizer stringTokenizer = new StringTokenizer(input);
            int[] tempArray = new int[3];

            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                tempArray[i] = num * num;
            }

            // 조건에 맞춰 StringBuilder에 추가하기
            if (tempArray[0] + tempArray[1] == tempArray[2]
                    || tempArray[0] + tempArray[2] == tempArray[1]
                    || tempArray[2] + tempArray[1] == tempArray[0]) {
                stringBuilder.append("right\n");
            } else {
                stringBuilder.append("wrong\n");
            }
        }
        // StringBuilder 한 번에 출력하기
        System.out.println(stringBuilder);
    }
}
