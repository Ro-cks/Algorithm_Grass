import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        int answer = 0;
        for (int i = 0; i < N - 2; ++i) {
            for (int j = i + 1; j < N - 1; ++j) {
                for (int k = j + 1; k < N; ++k) {
                    
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    if (nums[i] + nums[j] + nums[k] > M) break;
                    
                    if (sum > answer) answer = sum; 
                }
            }
        }
        
        System.out.println(answer);
    }
}