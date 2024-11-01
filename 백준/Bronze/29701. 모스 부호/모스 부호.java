import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 첫 줄: 원래 문자열의 길이 (사용하지 않지만 형식상 입력 받음)
        int N = scanner.nextInt();
        scanner.nextLine();  // 줄바꿈 문자 소모
        
        // 둘째 줄: 모스 부호로 변환된 메시지
        String morseMessage = scanner.nextLine();
        
        // 모스 부호와 해당 문자를 매핑하는 HashMap 생성
        HashMap<String, String> morseMap = new HashMap<>();
        
        // 모스 부호와 알파벳, 숫자, 기호를 매핑
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");
        morseMap.put(".----", "1");
        morseMap.put("..---", "2");
        morseMap.put("...--", "3");
        morseMap.put("....-", "4");
        morseMap.put(".....", "5");
        morseMap.put("-....", "6");
        morseMap.put("--...", "7");
        morseMap.put("---..", "8");
        morseMap.put("----.", "9");
        morseMap.put("-----", "0");
        morseMap.put("--..--", ",");
        morseMap.put(".-.-.-", ".");
        morseMap.put("..--..", "?");
        morseMap.put("---...", ":");
        morseMap.put("-....-", "-");
        morseMap.put(".--.-.", "@");
        
        // 모스 메시지를 공백으로 분리
        String[] morseCodes = morseMessage.split(" ");
        
        // 해독 결과를 저장할 StringBuilder
        StringBuilder decodedMessage = new StringBuilder();
        
        // 각 모스 부호를 순회하며 해독
        for (String code : morseCodes) {
            // HashMap에서 해당 모스 부호의 해독된 문자 찾기
            String decodedChar = morseMap.get(code);
            if (decodedChar != null) {
                decodedMessage.append(decodedChar);
            }
        }
        
        // 결과 출력
        System.out.println(decodedMessage.toString());
        
        scanner.close();
    }
}
