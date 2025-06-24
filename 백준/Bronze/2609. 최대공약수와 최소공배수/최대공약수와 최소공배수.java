import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 입력 받기
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int sqrtNum1 = (int) Math.sqrt(num1);
            int sqrtNum2 = (int) Math.sqrt(num2);

            // num1 소인수분해 결과 리스트에 저장하기
            LinkedList<Integer> list1 = new LinkedList<>();
            int temp = num1;
            for (int i = 2; i <= sqrtNum1; i++) {
                while (temp % i == 0) {
                    list1.add(i);
                    temp /= i;
                }
            }
            list1.add(temp);

            // num2 소인수분해 결과 리스트에 저장하기
            ArrayList<Integer> list2 = new ArrayList<>();
            temp = num2;
            for (int i = 2; i <= sqrtNum2; i++) {
                while (temp % i == 0) {
                    list2.add(i);
                    temp /= i;
                }
            }
            list2.add(temp);

            // 소인수 중 공통인 것만 추려서 최대공약수 도출하기
            int LCD = 1;
            if (!list1.isEmpty() && !list2.isEmpty()) {
                for (Integer i : list2) {
                    if (list1.contains(i)) {
                        LCD *= i;
                        list1.remove(i);
                    }
                }
            }

            // 두 수의 곱에서 최대공약수 나눠서 최소공배수 도출하기
            int LCM = num1 * num2 / LCD;

            // 정답 출력하기
            StringBuilder sb = new StringBuilder();
            sb.append(LCD).append('\n').append(LCM);
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
