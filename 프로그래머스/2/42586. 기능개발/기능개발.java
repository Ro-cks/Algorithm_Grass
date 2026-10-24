import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int funcLength = progresses.length;
        if (funcLength < 2) return new int[] {1};
        
        int[] remainDays = new int[funcLength];
        
        for (int i = 0; i < funcLength; ++i) {
            int remainProgress = 100 - progresses[i];
            int speed = speeds[i];
            int remainDay = (remainProgress + speed - 1) / speed;
            remainDays[i] = remainDay;
        }
        
        List<Integer> list = new ArrayList<>();
        int value = remainDays[0];
        int count = 1;
        for (int i = 1; i < funcLength; ++i) {
            if (remainDays[i] <= value) {
                ++count;
            } else {
                list.add(count);
                count = 1;
                value = remainDays[i];
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}