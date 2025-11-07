package day03.hanoi;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private ArrayList<int[]> moveList = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        
 /*       int[][] answer = new int[moveList.size()][2];
        for(int i=0; i<moveList.size(); i++){
            answer[i] = moveList.get(i);
        }*/
 //       int[][] answer = moveList.toArray(new int[moveList.size()][]);
        int[][] answer = moveList.stream().toArray(int[][]::new);
        
        return answer;

        
    }
    
    private void hanoi(int n, int from, int to, int middle){
         if(n==1){ // 원판의 갯수가 1개만 남았을 때 : 종료 조건(Base case)
            // 1개만 남으면, from(시작기둥) -> to(목표기둥)으로 이동 시키면 끝
             moveList.add(new int[]{from, to});
             return;
         }   
        
        // n-1개의 원판을 middle(보조기둥)으로 옮기고
        hanoi(n-1, from, middle, to);
        // 가장 큰 원판을 to(목표 기등)으로 옮기고
        moveList.add(new int[]{from, to});
        // middle(보조기둥)에 있는 n-1개의 원판을 목표 기둥으로 옮김
        hanoi(n-1, middle, to, from);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 3; // 옮길 원판 개수
        int[][] result = sol.solution(n);
        
        System.out.println("하노이 탑 이동 순서 (" + n + "개):");
        for(int[] move : result){
            System.out.println(Arrays.toString(move));; // [시작, 목표]
        }
        System.out.println("총 이동 횟수: " +result.length);
    }
}