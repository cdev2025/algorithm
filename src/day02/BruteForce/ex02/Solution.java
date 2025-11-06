package day02.BruteForce.ex02;

import java.util.ArrayList;
import java.util.Arrays;

// 모의고사 (Lv.1)
public class Solution {

    public int[] solution(int[] answers) {
        // 각 수포자의 찍기 패턴 정의
        int[][] patterns = {
            {1, 2, 3, 4, 5},            // 1번 수포자
            {2, 1, 2, 3, 2, 4, 2, 5},   // 2번 수포자
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 3번 수포자
        };

        int[] scores = new int[3]; // 각 수포자의 점수

        // 정답과 패턴 비교
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 가장 높은 점수 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 최고 점수 받은 사람 찾기
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                list.add(i + 1); // 사람 번호(1, 2, 3)
            }
        }

        // 결과를 배열로 변환
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 테스트용 main() 메서드
    public static void main(String[] args) {
        Solution s = new Solution();

        // 테스트 케이스 1
        int[] answers1 = {1, 2, 3, 4, 5};
        System.out.println("테스트 케이스 1 결과: " + Arrays.toString(s.solution(answers1))); 
        // [1]

        // 테스트 케이스 2
        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println("테스트 케이스 2 결과: " + Arrays.toString(s.solution(answers2))); 
        // [1, 2, 3]
    }
}