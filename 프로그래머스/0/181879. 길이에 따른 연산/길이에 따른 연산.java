class Solution {
    public int solution(int[] num_list) {
        boolean isOver = num_list.length >= 11 ? true : false;
        int answer;
        
        if (isOver) {
            answer = 0;
            for (int num : num_list) {
                answer += num;
            }
        } else {
            answer = 1;
            for (int num : num_list) {
                answer *= num;
            }
        }
        
        return answer;
    }
}