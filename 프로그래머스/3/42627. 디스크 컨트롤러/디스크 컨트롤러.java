/*
모든 작업을 끝내는 평균 시간의 정수부분 반환하기
작업 시간 = 작업 종료 시각 - 요청 시각

1. 대기 큐 (작업 소요시간이 짧은 것, 요청 시각이 빠른 것, 작업의 번호가 작은 것 순)
*/
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        
        int[][] list = new int[n][];
        for (int i = 0; i < n; ++i) {
            list[i] = new int[] {jobs[i][0], jobs[i][1], i};
        }
        Arrays.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2], b[2]);
        });
        
        int time = 0;
        int done = 0;
        int idx = 0;
        long total = 0;
        
        while (done < n) {
            while (idx < n && list[idx][0] <= time) {
                pq.offer(list[idx++]);
            }
            
            if (pq.isEmpty()) {
                time = list[idx][0];
                continue;
            }
            
            int[] job = pq.poll();
            time += job[1];
            total += time - job[0];
            ++done;
        }
        
        return (int) (total / n);
    }
}