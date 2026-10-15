class Solution {
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons, visited);
        
        return answer;
    }

    private void dfs(int fatigue, int count, int[][] dungeons, boolean[] visited) {
        // 1. 지금까지 탐험한 개수로 최댓값 갱신
        answer = Math.max(answer, count);
        // 2. 아직 안 갔고, 들어갈 수 있는 던전으로
        //    방문 표시 → 재귀 → 방문 표시 되돌리기
        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(fatigue - dungeons[i][1], count + 1, dungeons, visited);
                visited[i] = false;
            }
        }
    }
}