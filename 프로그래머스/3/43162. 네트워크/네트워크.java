class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for (int i = 0; i < n; ++i) parents[i] = i;
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (computers[i][j] == 1) union(i, j);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; ++i) {
            if (parents[i] == i) ++answer;
        }
        
        return answer;
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