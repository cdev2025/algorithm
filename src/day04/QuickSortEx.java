package day04;

import java.util.Arrays;

public class QuickSortEx {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        quickSort(arr, 0, arr.length-1); // 퀵 정렬 수행

        System.out.println("Sorted array: " + Arrays.toString(arr));
        
    }

    // 퀵 정렬을 수행하는 메서드
    public static void quickSort(int[] arr, int start, int end){
        // 퀵정렬을 수행할 때, pivot을 기준으로 분할 => 더이상 분할 될 내용이 없으면 종료
        // 원소가 1개만 남았을 때 = 시작 인덱스가 끝 인덱스보다 크거나 같으면 종료
        if (start >= end) return;

        // 분할 : 피벗을 기준으로 배열을 두 부분으로 나눔
        int pivot = partition(arr, start, end);

        // 피벗을 제외한 왼쪽 부분 배열 정렬 수행
        quickSort(arr, start, pivot-1);

        // 피벗을 제외한 오른쪽 부분 배열 정렬 수행
        quickSort(arr, pivot+1, end);
    }

    // 배열을 피벗을 기준으로 분할하고, 피벗의 최종 위치를 반환하는 메서드
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end]; // 피벗은 배열의 마지막 요소로 선택
        int i = (start -1 );// 피벗보다 작은 요소들의 마지막 인덱스를 가리키는 포인터 : 초기값 start-1(mininum보다 작은값);

        for(int j=start; j<end; j++){
            // 현재 요소가 피벗보다 작거나 같은 경우
            if(arr[j] <= pivot){
                i++; // 피벗보다 작은 요소들의 마지막 인데스를 한 칸 오른쪽으로 이동

                // i와 j 위치의 요소 교환
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗을 i+1 위치로 교환해서 피벗 최종 위치를 확정
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        // 피벗의 최종 위치 반환
        return i+1;
    }


}
