import java.io.*;
import java.util.*;

class Solution {    
    int[] dr = {1, 0, 0, -1};
    int[] dc = {0, -1, 1, 0};
    char[] cd = {'d', 'l', 'r', 'u'};
    
    int N, M, K;
    int endR, endC;
    String answer = "impossible";
    StringBuilder sb = new StringBuilder();
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        endR = r - 1;
        endC = c - 1;
        K = k;
        
        DFS(0, x - 1, y - 1, sb);
        
        return answer;
    }
    
    public void DFS(int depth, int cr, int cc, StringBuilder sb) {
        if (!answer.equals("impossible")) {
            
            return;
        }
        
        int distance = getDistance(cr, cc, endR, endC);
        if (depth + distance > K || (K - (depth + distance)) % 2 != 0) {
            
            return;
        }
        
        if (depth == K) {
            if (cr == endR && cc == endC) {
                answer = sb.toString();
            }
            
            return;
        }
        
        for (int d = 0; d < 4; ++d) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            
            sb.append(cd[d]);
            DFS(depth + 1, nr, nc, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public int getDistance(int r1, int c1, int r2, int c2) {
        
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}