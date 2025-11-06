package day02;

public class RecursionEx02 {
    public static void main(String[] args) {
        printInBinary(1234);
    }

    // 음이 아닌 정수 n을 2진수로 변환하여 출력하는 함수
    public static void printInBinary(int n){
        // 1. Integer.toBinaryString() 메서드 사용 : 10011010010
        // System.out.println(Integer.toBinaryString(n));

        // 2. 반복문 사용 : 10011010010
  /*      StringBuilder binary = new StringBuilder();
        if (n==0){
            binary.append(0);
        }
        while (n>0) {
            binary.insert(0, n%2); // 결과 문자열 앞에 2진수 한 자리 추가
            n /= 2;
        }
        
        System.out.print(binary.toString());
        */

        // 3. 재귀 : 10011010010
        if (n<2) System.out.print(n);
        else{
            printInBinary(n/2);// n을 2로 나눈 몫을 먼저 2진수로 변환해서 출력하고,
            System.out.print(n%2);// n을 2로 나눈 나머지 출력 
        }
    }
}
