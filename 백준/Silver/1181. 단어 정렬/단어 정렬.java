import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

// Arrays.sort 메소드에 Comparator를 구현하여 커스텀 정렬하기(1순위-문자열길이, 2순위-사전순)
// Comparator 클래스에 compare 메서드를 오버라이딩하여 정렬 방법 구현
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int total = Integer.parseInt(bufferedReader.readLine());

            // HashSet for excluding same words
            HashSet<String> stringSet = new HashSet<>();

            // looping for total words count
            for (int i = 0; i < total; i++) {
                stringSet.add(bufferedReader.readLine().trim());
            }

            // converting set into array to sort
            String[] stringArray = new String[stringSet.size()];
            stringSet.toArray(stringArray);

            // sorting array with custom sorting method
            Arrays.sort(stringArray, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o1.length() - o2.length();
                }
            });

            // Printing the result all at once with StringBuilder
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : stringArray) {
                stringBuilder.append(string).append("\n");
            }
            bufferedWriter.write(stringBuilder.toString());
        }
    }
}
