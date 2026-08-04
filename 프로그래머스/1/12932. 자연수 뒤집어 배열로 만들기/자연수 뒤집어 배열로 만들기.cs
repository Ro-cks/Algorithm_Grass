using System.Linq;

public class Solution 
{
    public int[] solution(long n) 
    {
        return n.ToString().Reverse().Select(c => c - '0').ToArray();
    }
}