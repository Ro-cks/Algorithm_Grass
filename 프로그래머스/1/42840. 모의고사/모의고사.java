// 1. 각 수포자의 찍기 패턴을 배열로 생성
// 2. 문제의 개수가 패턴 길이보다 길 경우 다시 처음으로 돌아옴.
// 3. 패턴과 문제 답이 일치하면 점수를 올림.
// 4. 가장 점수가 높은 사람을 출력할 배열에 넣음.
// 5. 동점자의 경우 오름차순으로 정렬.

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5}, 
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; ++i) {
            for (int j = 0; j < patterns.length; ++j) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    ++scores[j];
                }
            }
        }
        
        // 가장 높은 점수 저장
        int maxScore = 0;
        for (int score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; ++i) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}