import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int maxPicks = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // 포켓몬 종류의 수와 고를 수 있는 최대 마리 수 중 더 작은 값을 반환
        return Math.min(set.size(), maxPicks);
    }
}