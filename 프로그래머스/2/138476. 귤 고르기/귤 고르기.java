import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> sizes = new HashMap<>();
        for (int size : tangerine) {
            sizes.put(size, sizes.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int count : sizes.values()) {
            list.add(count);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        while (k > 0) {
            for (int count : list) {
                k -= count;
                ++answer;
                if (k <= 0) break;
            }
        }
        
        return answer;
    }
}