class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        int length = t.length()-p.length()+1;

        long[] intArray = new long[length];

        for (int i = 0; i < length; i++) {
            intArray[i] = Long.parseLong(t.substring(i, i+p.length()));
        }
        
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i]<=Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }
}