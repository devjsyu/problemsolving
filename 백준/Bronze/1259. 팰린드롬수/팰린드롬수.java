import java.io.*;
import java.util.Stack;

// JCF Stack 활용하기
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringBuilder st = new StringBuilder();
            while (true) {
                String string = br.readLine();

                if (string.equals("0")) break;

                // check
                char[] charArray = string.toCharArray();
                if (check(charArray)) {
                    st.append("yes\n");
                } else {
                    st.append("no\n");
                }
            }

            bw.write(st.toString());
        }
    }

    static boolean check(char[] charArray) {
        Stack<Character> digitsStack = new Stack<>();

        for (char c : charArray) {
            digitsStack.push(c);
        }

        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != digitsStack.pop()) {
                return false;
            }
        }

        return true;
    }
}
