package day04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSortEx {
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 7, 5, 2}; // 정렬할 배열
        
        int[] sortedArr = countingSort(arr); // 카운팅 정렬 수행

        System.out.println("Sorted arr: " + Arrays.toString(sortedArr));
    }

    public static int[] countingSort(int[] arr){
        int arrLength = arr.length;
        int[] output = new int[arrLength]; // 정렬된 배열을 저장할 공간

        // 가정: 입력된 숫자는 0~9까지의 정수이다.
        int[] count = new int[10]; // 각 숫자의 개수를 저장할 배열

        // 각 숫자의 개수를 센다
        for(int i=0; i<arrLength; i++){
            count[arr[i]]++;
        }

        // count 배열을 변경하여, 각 숫자 이하의 숫자들의 총 개수를 저장한다. (누적)
        for(int i=1; i<10; i++){
            count[i] +=count[i-1];
        }

        // 출력 배열을 만듦. 배열의 끝부터 시작해서 안정 정렬을 보장
        for (int i=arrLength-1; i>=0; i--){
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--; //다음 같은 숫자를 위해 count값을 줄인다.
        }

        return output;

    }
}
