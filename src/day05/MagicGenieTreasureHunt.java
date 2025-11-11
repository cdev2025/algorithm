package day05;

import java.util.Scanner;

// https://makernari.notion.site/26258b0b4ef581e3be27c85e4a9b0130

public class MagicGenieTreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 상자의총 수 N과 보물 상자의 번호 입력 받기
        int N = scanner.nextInt();
        int treasureBox = scanner.nextInt();

        // 검색 범위 초기 설정
        int left = 1; 
        int right = N;
        int attempts = 0; // 시도 횟수

        // 바이너리 서치
        while(left <= right){
            int mid = (left+right) /2; // 중간점 계산
            attempts++; // 시도 횟수 증가

            if(mid == treasureBox){
                System.out.println(attempts);
                break;
            }else if(mid < treasureBox){
                // 중간점보다 보물 상자의 번호가 크다면, 검색 범위를 오른쪽으로 조정
                left = mid+1;
            }else{
                // 중간점보다 보물 상자의 번호가 작다면, 검색 범위를 왼쪽으로 조정
                right = mid-1;
            }
        }

        scanner.close();
    }
    
}
