import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> set = new HashSet<>();

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int len = 1; len <= n; len++) {
                // 1. sum에 새 원소 더하기
                sum += elements[(start + len - 1) % n];
                // 2. sum을 set에 넣기
                set.add(sum);
            }
        }

        return set.size();
    }
}