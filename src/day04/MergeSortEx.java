package day04;

import java.util.Arrays;

public class MergeSortEx {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        mergeSort(arr, 0, arr.length-1);  // 병합 정렬 수행

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
    // 병합 정렬 수행하는 메서드
    public static void mergeSort(int[] arr, int left, int right){
        if( left < right){ // 분할할 배열이 1개 이상의 요소를 가지고 있는 경우
            int mid = (left + right) / 2; // 중간 지점 계산

            // 분할 정복 방식으로 각 부분 배열 정렬
            mergeSort(arr, left, mid);// 왼쪽 부분 배열 정렬
            mergeSort(arr, mid+1, right);// 오른쪽 부분 배열 정렬

            // 정렬된 부분 배열들 병합
            merge(arr, left, mid, right);
        }
    }

    // 두 부분 배열을 병합하는 메서드
    private static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[arr.length]; // 병합된 요소를 임시로 저장할 배열
        int i = left; // 왼쪽 부분 배열의 시작 인덱스
        int j = mid+1; // 오른쪽 부분 배열의 시작 인덱스
        int k = left; // 임시 배열의 인덱스

        // 왼쪽과 오른쪽 부분 배열의 요소를 비교하여 작은 값을 임시 배열에 순서대로 삽입
        while (i<=mid && j<=right){
            if(arr[i] <= arr[j] ){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        // 왼쪽 부분 배열에 남은 요소가 있으면 임시 배열에 삽입
        while( i<= mid){
            temp[k++] = arr[i++];
        }

        // 오른쪽 부분 배열에 남은 요소가 있으면 임시 배열에 삽입
        while( j <= right ){
            temp[k++] = arr[j++];
        }

        // 임시 배열의 요소를 원래 배열에 복사
        for(int l = left; l<=right; l++){
            arr[l] = temp[l];
        }
    }
}
