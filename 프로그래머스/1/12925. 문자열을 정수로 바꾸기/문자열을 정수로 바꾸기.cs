public class Solution {
    public int solution(string s) {
        int answer = 0;
        
        bool isSuccess = int.TryParse(s, out answer);
        
        if (isSuccess)
        {
            return answer;
        }
        else
        {
            return 0;
        }
    }
}