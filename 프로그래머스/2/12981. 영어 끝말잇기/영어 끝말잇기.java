import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String word = words[i];

            boolean wrongStart = prev.charAt(prev.length() - 1) != word.charAt(0);
            if (wrongStart || used.contains(word)) {
                return new int[]{i % n + 1, i / n + 1};
            }
            used.add(word);
        }
        return new int[]{0, 0};
    }
}