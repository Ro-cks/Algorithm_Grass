class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;   // 기지국 하나가 덮는 칸 수
        int start = 1;           // 아직 전파가 안 닿은 첫 위치

        for (int s : stations) {
            // 이 기지국의 범위가 시작되기 전까지가 빈 구간
            int len = (s - w) - start;
            // 빈 구간 길이로 필요한 기지국 수 계산
            if (len > 0) {
                answer += (len + cover - 1) / cover;
            }
            // start를 이 기지국 범위의 다음 칸으로 옮기기
            start = s + w + 1;
        }

        // 마지막 기지국 뒤에 남은 구간 처리
        int len = n - start + 1;
        if (len > 0) {
            answer += (len + cover - 1) / cover;
        }
        
        return answer;
    }
}