import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        
        while (n > 0) {
            if (pq.peek() == 0) return 0;
            
            int work = pq.poll() - 1;
            pq.offer(work);
            --n;
        }
        
        for (int i = 0; i < works.length; ++i) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}