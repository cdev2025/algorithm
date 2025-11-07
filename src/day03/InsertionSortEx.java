package day03;

import java.util.Arrays;

public class InsertionSortEx {

    // 삽입정렬(오름차순)
    public static void insertionSort(int[] arr){
        // 배열의 길이만큼 반복
        for(int i=1; i<arr.length; i++){ // 배열의 두번째 원소부터 시작
            int current = arr[i];
            int j=i-1; // [현재 원소 이전]의 요소들과 비교해서 삽입

            // 현재원소보다 큰 arr[j]를 찾아서 
            // currnet(현재원소)가 들어갈 위치를 정하기 위해서, 더 큰 원소들을 한칸씩 뒤로 옮김
            while(j >= 0 && arr[j] > current){
                arr[j+1] = arr[j]; // 원소를 뒤로 이동
                j = j-1; // 이전 인덱스
            }

            // while 루프 벗어난 위치에 current 값 삽입
            arr[j+1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        insertionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
}
