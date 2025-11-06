package day02;

import java.util.Arrays;

public class RecursionEx03 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 10, 5, 1, 29, 31, 7};
        System.out.println("합을 구할 배열: " +  Arrays.toString(arr));
        System.out.println("배열 요소의 합: : " + sum(arr.length, arr));
    }

    // 배열의 합을 구하는 메서드
    // data[0]에서 data[n-1]까지 합을 구해서 반환
    public static int sum(int n, int[] data){
        // 반복문으로 구현
/*       int total = 0; 
        for(int i=0; i<n; i++){
            total += data[i];
        }
        return total;*/

        // 재귀
        if (n<=0) return 0;
        else 
            return sum(n-1, data) + data[n-1];
    }
}
