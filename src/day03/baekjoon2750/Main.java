package day03.baekjoon2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수 N 입력 받기
        try {
            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];

            // 입력 받은 숫자들을 배열에 저장
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(br.readLine());
            }

            // Arrays.sort() 사용해서 배열 정렬
            // Arrays.sort(numbers);
            bubbleSort(numbers);

            // 정렬된 배열 출력
            // System.out.println(Arrays.toString(numbers));
            for(int number : numbers){
                System.out.println(number);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

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
}
