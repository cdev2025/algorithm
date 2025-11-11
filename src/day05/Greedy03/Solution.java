package day05.Greedy03;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ===== 테스트 입력 =====
        String number1 = "1924";
        int k1 = 2;

        String number2 = "1231234";
        int k2 = 3;

        String number3 = "4177252841";
        int k3 = 4;

        // ===== 실행 결과 출력 =====
        System.out.println("[테스트 케이스 1] " + sol.solution(number1, k1)); // 94
        System.out.println("[테스트 케이스 2] " + sol.solution(number2, k2)); // 3234
        System.out.println("[테스트 케이스 3] " + sol.solution(number3, k3)); // 775841
    }

    // ==================================================
    // 큰 수 만들기 (Greedy)
    // ==================================================
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;   // 현재 선택된 숫자의 인덱스
        int comp = 0;  // 다음 비교를 시작할 인덱스

        // 남겨야 하는 숫자의 개수만큼 반복
        for (int i = 0; i < number.length() - k; i++) {
            char max = '0';
            // 현재 인덱스부터 제거 가능한 범위까지 순회하며 최대값 찾기
            for (int j = comp; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j;
                }
            }
            // 최대값 추가
            answer.append(max);
            // 다음 비교 시작 위치 갱신
            comp = idx + 1;
        }

        return answer.toString();
    }
}
