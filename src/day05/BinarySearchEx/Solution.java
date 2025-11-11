package day05.BinarySearchEx;

class Solution {
    public static void main(String[] args) {
        int n =6;
        int[] times = {7, 10};

        Solution sol = new Solution();
        long result = sol.solution(n, times);

        System.out.println("모든 사람이 심사를 마치는 최소 시간: " + result);
        // 예상 출력 : 28
    }

    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE; // 가능한 최대 시간으로 초기화
        long left = 1; // 가능한 최소 시간
        long right = 0; // 가능한 최대 시간
        
        for (int time : times) {
            right = Math.max(right, (long) time * n); // 가장 긴 심사 시간으로 초기화
        }
        
        while (left <= right) {
            long mid = (left + right) / 2; // 중간값으로 시간 설정
            long sum = 0; // mid 시간 동안 심사할 수 있는 사람의 수
            
            // 현재 mid 시간동안 심사할 수 있는 인원 계산
            for (int time : times) {
                sum += mid / time;
            }
            
            // 심사할 수 있는 인원이 n보다 많거나 같다면, 답이 될 수 있는 후보
            if (sum >= n) {
                answer = Math.min(answer, mid); // 최소 시간 업데이트
                right = mid - 1; // 더 작은 시간 탐색을 위해 right 줄임
            } else {
                left = mid + 1; // 더 많은 시간 필요, left 증가
            }
        }
        
        return answer; // 최소 시간 반환
    }
}
