import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int index = sc.nextInt();

        Queue<Integer> integers = new LinkedList<>();
        for (int i = 1; i <= total; i++) {
            integers.add(i);
        }

        StringBuilder st = new StringBuilder();
        st.append("<");

        while (integers.size() > 1) {
            for (int i = 0; i < index - 1; i++) {
                integers.add(integers.poll());
            }
            st.append(integers.poll()).append(", ");
        }

        st.append(integers.poll()).append(">");

        System.out.println(st);
    }
}
