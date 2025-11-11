package day05.Greedy01;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        // ===== 테스트 입력 =====
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        Solution sol = new Solution();

        System.out.println("[테스트 케이스 1] " + sol.solution(n1, lost1, reserve1)); // 5
        System.out.println("[테스트 케이스 2] " + sol.solution(n2, lost2, reserve2)); // 4
        System.out.println("[테스트 케이스 3] " + sol.solution(n3, lost3, reserve3)); // 2
    }

    // ==================================================
    // 체육복 문제 해결 (Greedy Algorithm)
    // ==================================================
    public int solution(int n, int[] lost, int[] reserve) {
        // 각 학생의 체육복 개수를 나타내는 배열 (1-indexed)
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1); // 모든 학생은 기본적으로 체육복 1벌

        // 도난당한 학생: 체육복 -1
        for (int l : lost) {
            clothes[l]--;
        }

        // 여벌 있는 학생: 체육복 +1
        for (int r : reserve) {
            clothes[r]++;
        }

        // ===== 체육복 빌려주기 (앞번호 → 뒷번호 순서) =====
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) { // 체육복이 없는 학생이라면
                // 1️⃣ 앞번호 학생에게 빌릴 수 있는지 확인
                if (i > 1 && clothes[i - 1] > 1) {
                    clothes[i]++;
                    clothes[i - 1]--;
                }
                // 2️⃣ 앞에서 빌리지 못했으면 뒷번호 학생 확인
                else if (i < n && clothes[i + 1] > 1) {
                    clothes[i]++;
                    clothes[i + 1]--;
                }
            }
        }

        // 체육복이 1벌 이상 있는 학생 수 세기
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}

