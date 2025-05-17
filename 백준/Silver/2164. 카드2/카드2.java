import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        Queue<Integer> integers = new LinkedList<>();

        for (int i = 1; i <= total; i++) {
            integers.add(i);
        }

        for (int i = 0; i < total - 1; i++) {
            integers.poll();
            integers.add(integers.poll());
        }

        System.out.println(integers.poll());
    }
}
