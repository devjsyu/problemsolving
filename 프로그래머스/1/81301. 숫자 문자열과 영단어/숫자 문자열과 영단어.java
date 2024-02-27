class Solution {
    public int solution(String s) {
        int answer = 0;

        String[][] hashMap = {{"zero","0"},{"one","1"},{"two","2"},
                {"three","3"},{"four","4"},{"five","5"},{"six","6"},
                {"seven","7"},{"eight","8"},{"nine","9"}};

        for (int i = 0; i < hashMap.length; i++) {
            s = s.replace(hashMap[i][0],hashMap[i][1]);
        }

        return answer = Integer.parseInt(s);
    }
}