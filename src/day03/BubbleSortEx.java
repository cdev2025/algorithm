package day03;

import java.util.Arrays;

public class BubbleSortEx {
    // 버블 정렬(오름차순) 수행 메서드
    public static void bubbleSort(int[] arr){
        int n = arr.length; 

        // 전체 배열 순회
        for(int i=0; i<n-1; i++){
            // 정렬되지 않은 부분 순회 = 정렬된 뒷부분 점차 제외한다.
            for(int j=0; j<n-i-1; j++){
                // 현재 원소가 다음 원소보다 크면 두 원소의 위치를 교환
                if(arr[j] > arr[j+1]){
                    // arr[j]와 arr[j+1]의 값을 교환 :swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
