package day08;

/* 피보나치 수 : 앞의 두 숫자를 더해 다음 숫자를 만드는 수열
    0번째 = 0
    1번째 = 1
    2번째 = 1
    3번째 = 2
    ....
    n번째 = (n-1) + (n-2)
*/ 

// 피보나치 수열을 계산하는 세 가지 다른 방법 (일반 재귀, 타뷸레이션, 메모이제이션)
public class Fibo {
    
    // 일반 재귀 방식으로 피보나치 수열의 n번째 값을 계산하는 메서드
    // - 가장 직관적인 방법
    // - BUT: 같은 값을 여러 번 계산해서 매우 비효율적 (O(2^n))
    public static int FiboRecur(int num){
        if(num < 2 ) return num;   // base case: 0번째 피보나치 수 0, 1번째 피보나치 수 1
        // 재귀 호출 : n번째 피보나치 수는 (n-1)번째와 (n-2)번째 피보나치 수의 합
        return FiboRecur(num-1) + FiboRecur(num-2);
    }

    // 타뷸레이션(Tabulation, 상향식 접근) 방식을 사용한 피보나치 수열 계산
    //      0부터~n까지
    public static int FiboOne(int num){
        // DP 테이블 초기화 : 0부터 n까지 값을 저장할 수 있는 배열 생성
        int[] fiboArray = new int[num+1];
        // 1번째 피보나치 수는 1
        if(fiboArray.length > 1) fiboArray[1] = 1;

        // DP 테이블 채우기: 각 n번째 피보나치 수를 계산해서 배열에 저장
        for(int i=2; i<=num; i++){
            fiboArray[i] = fiboArray[i-1] + fiboArray[i-2];
        }

        // 최종적으로 num번째 피보나치 수 반환
        return fiboArray[num];
    }

    // 메모이제이션(Memoization, 하향식 접근) 방식을 사용한 피보나치 수열 계산
    static int[] fiboDP = new int[1000]; // 계산된 피보나치 수를 저장할 DP 테이블 : 0으로 초기화
    public static int FiboTwo(int num){
        if(num < 2) return num; // base case

        // 이미 계산된 값이 DP 테이블에 있으면, DP 테이블에서 값을 가져 옴
        if( fiboDP[num] != 0 ){
            return fiboDP[num];
        }

        // 아직 계산이 안됐으면 재귀 호출을 통해 값을 계산하고, DP 테이블에 저장
        fiboDP[num] = FiboTwo(num-1) + FiboTwo(num-2);
        return fiboDP[num];
    }


    public static void main(String[] args) {
        System.out.println(FiboRecur(10)); // 일반 재귀
        System.out.println(FiboOne(10)); // 타뷸레이션
        System.out.println(FiboTwo(10)); // 메모이제이션
    }
}
