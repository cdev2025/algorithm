package day05.baekjoon3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine()); // 목표 합
        Arrays.sort(arr);           // 정렬 : 투 포인터 전제

        int left = 0;
        int right = n-1;
        int count = 0;

        // -------- 양쪽 수렴형 투 포인터 -------------
        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum==target) {
                count++;
                left++;
                right--;
            } else if(sum < target){ //합이 작으면 왼쪽 증가
                left++;
            } else{ // 합이 크면
                right--;
            }

        }

        System.out.println(count);

    }
}
