import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 자료구조 준비
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String op : operations) {
            String[] parts = op.split(" ");
            String cmd = parts[0];
            int value = Integer.parseInt(parts[1]);
            
            if (cmd.equals("I")) {
                map.put(value, map.getOrDefault(value, 0) + 1);
                continue;
            }
            
            if (map.isEmpty()) continue;
            
            int key = (value == 1) ? map.lastKey() : map.firstKey();
            int count = map.get(key);
            if (count == 1) map.remove(key);
            else map.put(key, value - 1);
        }
        
        if (map.size() == 0) {
            return new int[] {0, 0};
        } else {
            return new int[] {map.lastKey(), map.firstKey()};
        }
    }
}