public class Solution {
    public string solution(string s) 
    {
        string answer = "";
        int min = int.MaxValue;
        int max = int.MinValue;

        string[] nums = s.Split();
        foreach (string num in nums)
        {
            var val = int.Parse(num);

            if (val < min)
            {
                min = val;
            }

            if (val > max)
            {
                max = val;
            }
        }

        answer = min + " " + max;

        return answer;
    }
}