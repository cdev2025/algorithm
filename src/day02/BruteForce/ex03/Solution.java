package day02.BruteForce.ex03;

import java.util.HashSet;
import java.util.Set;

//소수 찾기 (Lv.2)
public class Solution {

    // 주어진 문자열로 만들 수 있는 소수 개수 반환
    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>(); // 중복 제거용 Set
        permutation("", numbers, numberSet); // 모든 숫자 조합 생성

        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) count++;
        }
        return count;
    }

    /**
     * 재귀를 이용해 모든 숫자 조합을 생성하는 메서드
     */
    private void permutation(String prefix, String str, Set<Integer> numberSet) {
        int n = str.length();

        // 현재까지 만든 조합이 비어있지 않다면 Set에 추가
        if (!prefix.equals("")) {
            numberSet.add(Integer.parseInt(prefix));
        }

        // 현재 상태 출력 + 0.5초 대기 ( 아래 코드 주석 해제하고 확인하면 0.5초 간격으로 실행 내용 확인 가능 )
        // printCurrentState(prefix, str, numberSet);

        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, n),
                        numberSet);
        }
    }

    /**
     * 소수 판별 메서드
     */
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * 현재 상태를 출력하고 잠시 멈추는 메서드 (디버깅용)
     */
    private void printCurrentState(String prefix, String str, Set<Integer> numberSet) {
        System.out.println("prefix: " + prefix + ", remaining: " + str + ", numberSet: " + numberSet);
        try {
            Thread.sleep(500); // 0.5초 대기
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 테스트용 main 메서드
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 케이스 1
        String numbers1 = "17";
        System.out.println("\n[테스트 케이스 1] 입력: " + numbers1);
        int result1 = solution.solution(numbers1);
        System.out.println("결과: " + result1 + " (예상: 3)\n");

        // 테스트 케이스 2
        String numbers2 = "011";
        System.out.println("[테스트 케이스 2] 입력: " + numbers2);
        int result2 = solution.solution(numbers2);
        System.out.println("결과: " + result2 + " (예상: 2)\n");
    }
}

