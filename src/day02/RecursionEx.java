package day02;

// 문자열을 뒤집어 프린트
public class RecursionEx {
 public static void main(String[] args) {
    pirntCharReverse("Hello Java!");
 }   

 // 문자열을 뒤집어 프린하는 함수
 public static void pirntCharReverse(String str){
    // // 반복문으로 구현
    // for(int i=str.length()-1; i>=0; i--){
    //     System.out.print(str.charAt(i));
    // }

    // 재귀로 구현
    // Base Case: 종료 조건
    if (str.length()==0){
        return;
    }
    // 재귀 호출: 자기 자신을 호출
    pirntCharReverse(str.substring(1));
    System.out.print(str.charAt(0));
 }
}
