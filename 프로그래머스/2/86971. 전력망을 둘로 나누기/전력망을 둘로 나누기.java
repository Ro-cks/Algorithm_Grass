import java.util.*;

class Solution {    
    public int solution(int n, int[][] wires) {       
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i) graph.add(new ArrayList<>());
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int[] parent = new int[n + 1];
        List<Integer> order = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            order.add(curr);
            
            for (int next : graph.get(curr)) {
                if (visited[next]) continue;
                
                visited[next] = true;
                parent[next] = curr;
                q.offer(next);
            }
        }
        
        int[] size = new int[n + 1];
        int answer = Integer.MAX_VALUE;
        for (int i = order.size() - 1; i >= 0; --i) {
            int node = order.get(i);
            size[node] += 1;
            
            if (node != 1) {
                size[parent[node]] += size[node];
                int A = size[node];
                int B = n - A;
                answer = Math.min(answer, Math.abs(A - B));
            }
        }
        
        return answer;
    }
}