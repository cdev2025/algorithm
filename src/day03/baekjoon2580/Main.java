package day03.baekjoon2580; 

import java.util.Scanner;

public class Main {
    final static int BOARD_SIZE = 9;
    public static int[][] board = new int[BOARD_SIZE][BOARD_SIZE]; // 스도쿠 보드

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 스도쿠 판 초기 상태 입력 받기
        for(int i=0; i< BOARD_SIZE; i++){
            for(int j=0; j< BOARD_SIZE; j++){
                board[i][j] = scanner.nextInt();
            }
        }

        // System.out.println("==================="); //디버깅용

        // 백트래킹 시작
        solve(0,0);

        scanner.close();
    }

    public static boolean solve(int row, int col){
        // 현재 행이 9라면 스도쿠 판이 완성. => 출력하고 true 반환
        if(row == BOARD_SIZE){
            for( int i=0; i< BOARD_SIZE; i++){
                for( int j=0; j< BOARD_SIZE; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }

        // 현재 열이 9라면 다음 행의 첫번째 열로 이동
        if(col ==  BOARD_SIZE){
            return solve(row+1, 0);
        }

        // 현재 위치가 빈 칸인지 확인하고, 빈칸이면 가능한 숫자 시도
        if(board[row][col] == 0){
            for(int num=1; num <=9; num++){
                if(isValid(row, col, num)){// 유효한 숫자인지 확인 => 유효한 숫자이면
                    board[row][col] = num; // 보드에 해당 숫자 넣기
                    if( solve(row, col+1) ) { // 다음 칸으로 이동
                        return true;
                    }
                    board[row][col] = 0;// 백트래킹
                }
            }
            return false; // 실패한 경우 false 반환
        }else{ // 이미 숫자가 있는 경우 다음 칸으로 이동
            return solve(row, col+1);
        }
    }

    // 해당 위치에 숫자 num을 놓을 수 있는지 확인(유효성 함수: 유망성 검사)
    public static boolean isValid(int row, int col, int num) {
         // 1. 같은 행, 열에 동일한 숫자가 있는지 체크
         for(int i=0; i< BOARD_SIZE; i++){
            if(board[row][i] == num || board[i][col] == num){
                return false;
            }
         }

         // 2. 3x3 박스 체크
         int startRow = row - row%3;
         int startCol = col - col%3;
         for(int i=startRow; i<startRow+3; i++){
            for(int j=startCol; j<startCol+3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
         }

         return true; // 모든 체크 통과
    }
}
