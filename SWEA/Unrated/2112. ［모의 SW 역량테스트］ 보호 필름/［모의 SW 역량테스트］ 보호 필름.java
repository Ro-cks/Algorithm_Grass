import java.io.*;
import java.util.*;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
     
    static int T; // 테스트 케이스 
    static int D; // 행
    static int W; // 열
    static int K; // 합격 기준
    static int answer;
    
    static int[] inject;
    static int[][] film;
     
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; ++t) {
            sb.append('#').append(t).append(' ');
             
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = answer = Integer.parseInt(st.nextToken());
            if (K == 1) {
                sb.append(0).append('\n');
                filmInit();
                
                continue;
            }
            
            inject = new int[D];
             
            filmInit();
             
            subset(0, 0);
             
            sb.append(answer).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void subset(int cnt, int su) {
    	if (su >= answer) {
    		
    		return;
    	}
    	
    	
    	if (cnt == D) {
    		if (filmTest()) {
    			answer = Math.min(answer, su);
    		}
    		
    		return;
    	}
    	
    	inject[cnt] = -1;	// 그대로
    	subset(cnt + 1, su);
    	
    	inject[cnt] = 0;	// A 주입
    	subset(cnt + 1, su + 1);
    	
    	inject[cnt] = 1;	// B 주입
    	subset(cnt + 1, su + 1);
    }
     
    static boolean filmTest() {
        outer: for (int w = 0; w < W; ++w) {
		        	int cnt = 1;
		        	
		        	for (int d = 0; d < D - 1; ++d) {
		        		int curr = inject[d    ] == -1 ? film[d    ][w] : inject[d    ];
		        		int next = inject[d + 1] == -1 ? film[d + 1][w] : inject[d + 1];
		        		
		        		if (curr == next) {
		        			++cnt;
		        			
		        			if (cnt >= K) {
		        				
		        				continue outer;
		        			}
		        		} else {
		        			cnt = 1;
		        		}
		            }
		        	
		        	if (cnt < K) {
		        		
		        		return false;
		        	}
        		}
    
    	return true;
    }
     
    static void filmInit() throws IOException {
        film = new int[D][W];
         
        for (int i = 0; i < D; ++i) {
            st = new StringTokenizer(br.readLine());
             
            for (int j = 0; j < W; ++j) {
                film[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}