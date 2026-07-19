import java.io.*;
import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] strToChArr = my_string.toCharArray();
        
        for (int i = 0; i < n; ++i) {
            sb.append(strToChArr[i]);
        }
        
        return sb.toString();
    }
}