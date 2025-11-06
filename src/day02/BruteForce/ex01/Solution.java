package day02.BruteForce.ex01;

// 최소 직사각형(Lv.1)
class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0; // 가로 길이 최대 값
        int maxH = 0; // 세로 길이 최대 값

        for (int[] size : sizes){ // O(N)
            // 가로길이 = 가로 길이와 세로 길이 중에서 큰값 
            int w = Math.max(size[0], size[1]);
            // 세로길이 = 가로 길이와 세로 길이 중에서 작은 값 
            int h = Math.min(size[0], size[1]);

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }


        // 최대 가로 길이와 최대 세로 길이를 곱한 값이 지갑 크기
        return maxW * maxH;
    }

    // 테스트용 main()함수
    public static void main(String[] args) {
        Solution s = new Solution();

        // 테스트 케이스 1 : 4000
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println("테스트 케이스 1 결과 : " + s.solution(sizes1));

        // 테스트 케이스 2 : 120
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println("테스트 케이스 2 결과 : " + s.solution(sizes2));

        // 테스트 케이스 3 : 133
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println("테스트 케이스 3 결과 : " + s.solution(sizes3));
        
    }
}