import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 자원 반납을 위한 try-with resources
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            // 입력으로부터 변수 받기
            int total = Integer.parseInt(br.readLine());

            // 단일 출력을 위한 StringBuilder
            StringBuilder st = new StringBuilder();

            // 입력에 대한 스택 메서드 반환값을 StringBuilder에 추가하는 for loop
            for (int i = 0; i < total; i++) {
                String line = br.readLine();
                if (line.startsWith("push ")) {
                    line = line.substring(5);
                }
                int result = command(line);
                if (result != -2) {
                    st.append(result).append("\n");
                }
            }

            // 정답 출력
            bw.write(st.toString());
        }
    }

    // 필드 스택 초기화
    static Stack<Integer> stack = new Stack<>();

    // 문제에서 요구하는 스택 메서드 구현
    static int command(String string) {
        int result = -2;
        try {
            switch (string) {
                case "top" : result =  stack.peek();
                    break;
                case "size" : result =  stack.size();
                    break;
                case "empty" : result =  stack.empty() ? 1 : 0;
                    break;
                case "pop" : result =  stack.pop();
                    break;
                default : stack.push(Integer.parseInt(string));
                    break;
            }
        } catch (EmptyStackException e) {
            return -1;
        }
        return result;
    }
}
