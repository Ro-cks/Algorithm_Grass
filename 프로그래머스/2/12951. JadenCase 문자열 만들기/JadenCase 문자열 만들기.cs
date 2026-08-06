using System;
using System.Text;

public class Solution {
    public string solution(string s) {
        StringBuilder answer = new StringBuilder();
        bool isFirstChar = true;
        
        foreach (char ch in s)
        {
            if (ch == ' ')
            {
                answer.Append(ch);
                isFirstChar = true;
            }
            else
            {
                if (isFirstChar)
                {
                    answer.Append(char.ToUpper(ch));
                    isFirstChar = false;
                }
                else
                {
                    answer.Append(char.ToLower(ch));
                }
            }
        }
        
        return answer.ToString();
    }
}