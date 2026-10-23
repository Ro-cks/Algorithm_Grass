import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; ++i) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> window = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                // 질문 2: window에 discount[j] 세기
                window.put(discount[j], window.getOrDefault(discount[j], 0) + 1);
            }
            if (window.equals(map)) answer++;
        }
        
        return answer;
    }
}