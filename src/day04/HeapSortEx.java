package day04;

import java.util.Arrays;

public class HeapSortEx {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        System.out.println("Sorted arr: " + Arrays.toString(arr));
    }

    // 힙 정렬 메서드
    public static void heapSort(int[] arr){
        int length = arr.length;

        // 배열을 최대 힙으로 구성
        for(int i=length/2 -1; i>=0; i--){
            heapify(arr, length, i);
        }

        // 힙에서 하나씩 요소를 꺼내서 배열의 마지막부터 채움 
        for (int i=length-1; i>=0; i--){
            // 푸트(최대값)와 마지막 요소를 표환
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 교환한 후, 다시 최대 힙 구성
            heapify(arr, i, 0);
        }
    }

    // 주어진 서브트리를 최대 힙으로 만드는 메서드
    public static void heapify(int[] arr, int heapSize, int rootIndex){
        int largest = rootIndex; // 가장 큰 요소의 인덱스 (초기값은 루트)
        int leftChildIdx = 2 * rootIndex + 1; // 왼쪽 자식 인덱스
        int rightChildIdx = 2 * rootIndex + 2; // 오른쪽 자식 인덱스

        // 왼쪽 자식이 현재 요소보다 크면, 가장 큰 요소를 왼쪽 자식으로 설정 (max heap)
        if(leftChildIdx<heapSize && arr[leftChildIdx] > arr[largest]){
            largest = leftChildIdx;
        }

        // 오른쪽 자식이 현재 요소보다 크면 가장 큰 요소를 오른쪽 자식으로 설정
        if(rightChildIdx<heapSize && arr[rightChildIdx]>arr[largest]){
            largest=rightChildIdx;
        }

        //가장 큰 요소가 루트가 아니면, 루트와 가장 큰 요소를 교환
        if(largest != rootIndex){
            int swap = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = swap;

            // 교환된 서브트리를 다시 최대 힙으로 만듦
            heapify(arr, heapSize, largest);
        }
    }
}

