class Solution {
    static int answer = 0;
    static int length;
    static boolean[] sequence;
    
    public int solution(int[] numbers, int target) {
        length = numbers.length;
        sequence = new boolean[length];
        
        DFS(0, target, numbers);
        
        return answer;
    }
    
    static void DFS(int depth, int target, int[] numbers) {
        if (depth == length) {
            int sum = 0;
            
            for (int i = 0; i < length; ++i) {
                if (sequence[i]) {
                    sum += numbers[i];
                } else {
                    sum += numbers[i] * -1;
                }
            }
            
            if (sum == target) ++answer;
            
            return;
        }
        
        sequence[depth] = true;
        DFS(depth + 1, target, numbers);
        sequence[depth] = false;
        DFS(depth + 1, target, numbers);
    }
}