class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1) return sticker[0];
        
        int[][] dp1 = new int[2][n];
        dp1[1][0] = sticker[0]; // 0번 스티커를 뜯으면
        for (int i = 1; i < n - 1; ++i) {
            dp1[0][i] = Math.max(dp1[0][i - 1], dp1[1][i - 1]);
            dp1[1][i] = dp1[0][i - 1] + sticker[i];
        }
        
        int[][] dp2 = new int[2][n];
        dp2[1][1] = sticker[1]; // 1번 스티커를 뜯으면
        for (int i = 2; i < n; ++i) {
            dp2[0][i] = Math.max(dp2[0][i - 1], dp2[1][i - 1]);
            dp2[1][i] = dp2[0][i - 1] + sticker[i];
        }
        
        return Math.max(Math.max(dp1[0][n - 2], dp1[1][n - 2]), Math.max(dp2[0][n - 1], dp2[1][n - 1]));
    }
}