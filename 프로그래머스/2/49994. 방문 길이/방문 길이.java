import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (char dir : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            
            if (dir == 'U') ++ny;
            else if (dir == 'D') --ny;
            else if (dir == 'R') ++nx;
            else if (dir == 'L') --nx;
            
            if (inRange(nx, ny)) {
                set.add(x + "," + y + "," + nx + "," + ny);
                set.add(nx + "," + ny + "," + x + "," + y);
                
                x = nx;
                y = ny;
            }
        }
        
        return set.size() / 2;
    }
    
    private static boolean inRange(int x, int y) {
        return x <= 5 && y <= 5 && x >= -5 && y >= -5;
    }
}