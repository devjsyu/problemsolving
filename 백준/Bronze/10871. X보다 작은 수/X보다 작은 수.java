import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

// X보다 작은 수
public class Main {
    public static void main(String[] args) throws IOException {
        // try-with-resources for auto close
        try (
                // BufferedReader for faster input
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            // Input N, X
            String inputSize = br.readLine();
            int i = inputSize.indexOf(" ");
            int numberN = Integer.parseInt(inputSize.substring(0,i));
            int numberX = Integer.parseInt(inputSize.substring(i+1));

            // Input Sequence
            String stringSequence = br.readLine();
            
            // split String and convert into List
            String[] split = stringSequence.split("\\s");

            // Stream API for mapping to int and filtering smaller ones
            String result = Arrays.stream(split)
                    .mapToInt(string -> Integer.parseInt(string))
                    .filter(num -> num < numberX)
                    .boxed()
                    .map(integer -> String.valueOf(integer))
                    .collect(Collectors.joining(" "));

            System.out.println(result);
        }
    }
}
