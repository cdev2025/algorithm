package day08.ex01;

import java.util.*;

class Solution {
    // 타뷸레이션. (전체 DP 테이블 구성 => 최소 사용 횟수 찾음)
    public int solution(int N, int number) {
        if (N==number) {
            // N과 number가 같은 경우, N을 1번만 사용하면 되므로  1을 반환
            return 1;
        }
        
        // 각각의 set은 N을 i번 사용해서 만들 수 있는 모든 숫자를 저장
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<=8; i++){
            list.add(new HashSet<>());
        }
        
        // N, NN, NNN 등을 미리 계산해서 추가
        int base = N;
        for( int i=1; i<=8; i++ ){
            list.get(i).add(base);
            base = base * 10 + N;
        }
        
        // 동적 계획법 : 타뷸레이션 시작
        for( int i=1; i<=8; i++){ // N을 i번 사용하는 경우 (1~8 번 사용)
            for(int j=1; j<i; j++){ // N을 j번 사용한 결과와 i-j번 사용한 결과를 조합
                for(Integer a: list.get(j)){ 
                    for(Integer b: list.get(i-j)){
                        // 사칙 연산
                        list.get(i).add(a+b); // 덧셈
                        list.get(i).add(a-b);
                        list.get(i).add(a*b);
                        if(b!=0){
                            list.get(i).add(a/b);
                        }
                    }
                }
                
            }
            
            //원하는 숫자를 찾은 경우, 현재 N 사용 횟수 반환
            if (list.get(i).contains(number)) {
            return i;
            }
        }
        
        
        // 8번을 초과하여 사용해야 하는 경우, 문제 조건 -1반환
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(5, 12)); // 4
        System.out.println(s.solution(2, 11)); // 3

        // 원하는 값 테스트
        System.out.println(s.solution(5,31168));    // -1
        System.out.println(s.solution(7, 123));     // 7
    }
}