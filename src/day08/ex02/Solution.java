package day08.ex02;

class Solution {
    public int solution(int[][] triangle) {
        // 삼각형의 높이: 1~500
        int height = triangle.length;
        
        // dp 배열을 이용. 각 단계에서의 최대 합을 저장
        // dp[i][j]는 triangle[i][j] 위치까지 도달했을 때의 최대 합
        int[][] dp = new int[height][height];
        
        // 시작 위치 초기화 
        dp[0][0] = triangle[0][0];
        
        // 삼각형의 각 층을 순회하면서 dp 배열 업데이트
        for(int i=1; i<height; i++){ // i : 층
            for(int j=0; j<=i; j++){ // j : 가로
                // 왼쪽 끝일 경우, 바로 위층 같은 위치에서만 내려올 수 있음
                if(j == 0 ){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                // 오른쪽 끝일 경우, 바로 위층 왼쪽에서만 내려올 수 있음
                else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                // 그 외, 위층의 같은 위치와 왼쪽에서 내려온 경우 중 최대값
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])  + triangle[i][j];
                }
            }
        } // end for(i)
        
        // 마지막 층에 도달 했을 때 최대 합을 찾음
        int answer = 0;
        for(int i=0; i<height; i++){ 
            answer = Math.max(answer, dp[height-1][i]);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] triangle = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };

        int result = sol.solution(triangle);
        System.out.println("최댓값: " + result);  // 30 출력

        // 추가 테스트
        int[][] triangle2 = {
            {5},
            {9, 6},
            {4, 6, 8},
            {0, 7, 1, 5}
        };

        System.out.println("최댓값: " + sol.solution(triangle2));  // 27 출력 예상
    }
}