import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 1. BFS 준비: 큐, 방문 표시(words 인덱스 기준), 단계 수 기록
        Queue<String> q = new ArrayDeque<>();
        int n = words.length;
        int wLength = begin.length();
        boolean[] visited = new boolean[n];
        int answer = 0;

        q.offer(begin);
        // 2. BFS
        //    - 꺼낸 단어가 target이면 그때의 단계 수 반환
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int s = 0; s < size; ++s) {
                String curr = q.poll();
                if (curr.equals(target)) return answer;

                for (int i = 0; i < n; ++i) {
                    if (!visited[i] && canConvert(curr, words[i])) {
                        visited[i] = true;
                        q.offer(words[i]);
                    }
                }
            }
            
            ++answer;
        }
        
        return 0;
    }

    private boolean canConvert(String a, String b) {
        int equalCount = 0;
        
        for (int i = 0; i < a.length(); ++i) {
            equalCount += (a.charAt(i) == b.charAt(i)) ? 1 : 0;
        }
        
        return equalCount == a.length() - 1;
    }
}