using System.Linq;

public class Solution 
{
    public long solution(long n) 
    {
        string answer = new string(n.ToString().OrderByDescending(c => c).ToArray());
        
        return long.Parse(answer);
    }
}