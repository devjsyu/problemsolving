import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution {
    public String solution(int a, int b) {
        String answer = "";

        // 1. LocalDate instance
        LocalDate date = LocalDate.of(2016, a, b);
        System.out.println(date);

        // 2. DayOfWeek instance
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        // 3. get day in text
        return answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();

    }
}