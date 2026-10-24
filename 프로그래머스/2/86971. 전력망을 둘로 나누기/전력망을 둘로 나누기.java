class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] wires) {       
        int answer = 101;
        
        for (int i = 0; i < n - 1; ++i) {            
            parents = new int[n + 1];
            for (int j = 0; j <= n; ++j) parents[j] = j;
            
            for (int k = 0; k < n - 1; ++k) {
                if (k == i) continue;
                
                int a = wires[k][0];
                int b = wires[k][1];
                union(a, b);
            }
            
            int A = calNet(find(1), n);
            int B = n - A;
            answer = Math.min(answer, Math.abs(A - B));
        }
        
        return answer;
    }
    
    private static int calNet(int x, int n) {
        int count = 0;
        
        for (int i = 1; i <= n; ++i) {
            if (find(i) == x) ++count;
        }
        
        return count;
    }
    
    private static int find(int x) {
        if (parents[x] != x) parents[x] = find(parents[x]);
        
        return parents[x];
    }
    
    private static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        
        if (ra == rb) return false;
        parents[rb] = ra;
        return true;
    }
}