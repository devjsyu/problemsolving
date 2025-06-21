import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int temp = 0;
        int count = 0;
        for (int i = N; i >= 1 ; i--) {
            temp = i;
            while (temp % 5 == 0) {
                count++;
                temp /= 5;
            }
        }

        System.out.println(count);
    }
}
