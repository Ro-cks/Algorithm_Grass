import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        
        int answer = arr[n - 1];
        while (true) {
            int count = 0;
            
            for (int i = 0; i < n; ++i) {
                if (answer % arr[i] != 0) break;
                else ++count;
            }
            
            if (count == n) return answer;
            
            ++answer;
        }
    }
}