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
            } else {
                if (map.isEmpty()) continue;
                
                if (value == 1) {
                    if (map.get(map.lastKey()) > 1) {
                        map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                    } else {
                        map.remove(map.lastKey());
                    }
                } else {
                    if (map.get(map.firstKey()) > 1) {
                        map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                    } else {
                        map.remove(map.firstKey());
                    }
                }
            }
        }
        
        if (map.size() == 0) {
            return new int[] {0, 0};
        } else {
            return new int[] {map.lastKey(), map.firstKey()};
        }
    }
}