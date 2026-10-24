class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            
            dfs(i, n, computers);
            ++answer;
        }
        
        return answer;
    }
    
    private static void dfs(int node, int n, int[][] computers) {
        visited[node] = true;
        
        for (int i = 0; i < n; ++i) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, n, computers);
            }
        }
    }
}