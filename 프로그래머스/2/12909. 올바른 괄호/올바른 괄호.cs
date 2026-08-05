using System;
using System.Collections.Generic;

public class Solution 
{
    public bool solution(string s) 
    {
        Stack<char> stack = new Stack<char>();

        foreach (char ch in s)
        {
            if (ch == '(')
            {
                stack.Push(ch);
            }
            else if (ch == ')')
            {
                if (stack.Count == 0) return false;

                stack.Pop();
            }
        }

        return stack.Count == 0;
    }
}