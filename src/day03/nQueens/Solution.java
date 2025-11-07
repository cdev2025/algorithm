package day03.nQueens;

class Solution {
    // 결과를 저장할 변수
    private int count = 0;
    // 각 열에 퀸 위치를 저장할 배열
    private int[] position;
    
    public int solution(int n) {
        position = new int[n];  // 체스판 크기에 맞는 배열 생성
        // 퀸 배치
        placeQueen(0, n); //첫번째 퀸부터 배치 시작
        
        return count; // 모든 가능한 배치의 수 반환
    }
    
    // 퀸 배치 메서드. row: 현재 행, n은 체스판 크기
    private void placeQueen(int row, int n)
    {
        // Base case : 종료조건 
        // 모든 행에 퀸을 배치 -> 하나의 유효한 해를 찾음
        if (row == n){
            count++; // 해의 개수 1 증가
            return;
        }
        
        // 현재 행의 각 열에 퀸을 배치 시도
        for (int col = 0 ; col < n; col++){
            if( isValid(row, col) )// 유효한 위치인가?(yes)
            {
                position[row] = col; // 현재 행에 퀸 배치
                placeQueen(row+1, n); // 다음 행에 퀸 배치 시도
            }
        }
    }
    
    // [현재 위치: row, col]에 퀸을 배치할 수 있는지 검사하는 메서드
    private boolean isValid(int row, int col){
        for(int i=0; i<row; i++){
            // 같은 열에 다른 퀸이 있는가? 또는 대각선에 다른 퀸이 있는가? 검사
            if(position[i] == col || Math.abs(row-i) == Math.abs(col - position[i])){
                return false; // 배치 불가
            }
        }
        return true; // 배치 가능
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4)); // 4개 퀸을 배치하는 방법 수 출력
    }
}
