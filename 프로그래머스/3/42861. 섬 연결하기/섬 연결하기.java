import java.util.*;

class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i = 0; i < n; ++i) parents[i] = i;
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        int answer = 0;
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            
            if (union(a, b)) {
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    private static int find(int a) {
        if (parents[a] != a) parents[a] = find(parents[a]);
        
        return parents[a];
    }
    
    private static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        
        if (ra == rb) return false;
        parents[rb] = ra;
        return true;
    }
}