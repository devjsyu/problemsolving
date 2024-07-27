import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 각 종류별 의상 수를 저장할 HashMap
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        // 의상의 종류별 개수를 HashMap에 저장
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        // 모든 조합의 수를 계산
        int answer = 1;
        for (int count : clothesMap.values()) {
            // 해당 종류의 의상을 입지 않는 경우를 포함하여 계산
            answer *= (count + 1);
        }
        
        // 모든 의상을 입지 않는 경우(1)를 제외
        answer -= 1;
        
        return answer;
    }
}
