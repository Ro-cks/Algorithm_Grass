import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int val : scoville) {
            pq.offer(val);
        }
        
        int answer = 0;
        int foodCount = scoville.length;
        while (foodCount > 1) {
            int min = pq.poll();
            if (min >= K) break;
            
            int nextMin = pq.poll();
            pq.offer(min + (nextMin * 2));
            --foodCount;
            ++answer;
        }
        
        if (pq.peek() < K) return -1;
        
        return answer;
    }
}