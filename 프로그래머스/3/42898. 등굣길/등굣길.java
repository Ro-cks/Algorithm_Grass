class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        int[][] dp = new int[m][n];
        boolean[][] isPuddle = new boolean[m][n];
        for (int[] p : puddles) {
            isPuddle[p[0] - 1][p[1] - 1] = true;
        }
        
        dp[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) continue;
                if (isPuddle[i][j]) continue;
                
                int fromLeft = (i > 0) ? dp[i - 1][j] : 0;
                int fromUp = (j > 0) ? dp[i][j - 1] : 0;
                dp[i][j] = (fromLeft + fromUp) % MOD;
            }
        }
        
        return dp[m - 1][n - 1];
    }
}