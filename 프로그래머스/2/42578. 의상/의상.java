import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> category = new HashMap<>();
        
        for (String[] cloth : clothes) {
            category.put(cloth[1], category.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (int value : category.values()) {
            answer *= value + 1;
        }
        
        answer -= 1;
        
        return answer;
    }
}