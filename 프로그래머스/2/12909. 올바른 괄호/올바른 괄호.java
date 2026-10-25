import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') { // 여는 괄호일 때
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek() == '(') { // 닫는 괄호일 때
                stack.pop();
            } else {
                return false;
            }
        }
        
        if (stack.isEmpty()) return true;
        return false;
    }
}