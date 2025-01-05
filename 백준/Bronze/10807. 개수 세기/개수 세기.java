import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        // Create an object for input
        Scanner sc = new Scanner(System.in);

        // Assign variables
        int size = sc.nextInt();
        sc.nextLine(); // Eliminating the remnant "\n" in the buffer
        String string = sc.nextLine();
        String num = sc.nextLine();
        int answer = 0;

        // Split string
        StringTokenizer st = new StringTokenizer(string, " ");

        // for loop with condition
        for (int i = 0; i < size; i++) {
            if (num.equals(st.nextToken())) {
                answer++;
            }
        }

        // Print
        System.out.println(answer);
    }
}
