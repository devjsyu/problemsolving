package week03;

// 3진법 뒤집기
// https://school.programmers.co.kr/learn/courses/30/lessons/68935

public class Main01 {
    public static void main(String[] args) {
        Main01 a = new Main01();
        System.out.println(a.solution(45));;
    }
    public int solution(int n) {
        int answer = 0;

        String decimalToTernary = Integer.toString(n, 3);
        String[] stringArray = decimalToTernary.split("");
        String[] reversedArray = new String[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            reversedArray[i] = stringArray[stringArray.length-1-i];
        }
        String joinedString = String.join("", reversedArray);
        answer = Integer.parseInt(joinedString, 3);

//        System.out.println(decimalToTernary);
//        System.out.println(Arrays.toString(stringArray));
//        System.out.println(Arrays.toString(reversedArray));
//        System.out.println(joinedString);
//        System.out.println(ternaryToDecimal);

        return answer;
    }
}
