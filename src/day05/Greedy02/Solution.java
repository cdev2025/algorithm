package day05.Greedy02;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ===== 테스트 입력 =====
        String name1 = "JEROEN";
        String name2 = "JAN";
        String name3 = "JAZ";

        // ===== 실행 결과 출력 =====
        System.out.println("[테스트 케이스 1] " + name1 + " → " + sol.solution(name1)); // ✅ 56
        System.out.println("[테스트 케이스 2] " + name2 + " → " + sol.solution(name2)); // ✅ 23
        System.out.println("[테스트 케이스 3] " + name3 + " → " + sol.solution(name3)); // ✅ 11
    }

    // =====================================================
    // 조이스틱 최소 조작 횟수 계산 (Greedy + 문자열 탐색)
    // =====================================================
    public int solution(String name) {
        int answer = 0;                    // 총 조작 횟수
        int length = name.length();        // 이름 길이
        int minMove = length - 1;          // 기본 이동 횟수 (맨 오른쪽까지 이동하는 경우)

        for (int i = 0; i < length; i++) {
            // ① 상하 이동 (각 알파벳을 만드는 최소 횟수)
            char target = name.charAt(i);
            int upDownCount = Math.min(target - 'A', 'Z' - target + 1);
            answer += upDownCount;

            // ② 좌우 이동 최소화 (연속된 'A' 구간 건너뛰기)
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 왼쪽으로 돌아가는 경우와 오른쪽으로 계속 가는 경우 중 최소값 선택
            minMove = Math.min(minMove, i * 2 + length - nextIndex);
            minMove = Math.min(minMove, (length - nextIndex) * 2 + i);
        }

        answer += minMove; // 상하 이동 + 좌우 이동 합산
        return answer;
    }
}
