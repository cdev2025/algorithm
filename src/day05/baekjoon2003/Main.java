package day05.baekjoon2003;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 연속된 구간의 합이 target이 되는 경우의 수 구하기 (슬라이딩 윈도우형 투 포인터 기본 문제)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left=0, right=0, count=0, sum=0;

        // ================같은 방향형(슬라이딩 윈도우) 투 포인터 ==============
        while(true){
            if(sum >= target) sum -= arr[left++]; // 합이 크면 왼쪽 이동
            else if(right==n) break; // 끝까지 탐색 완료
            else sum += arr[right++]; // 합이 작으면 오른쪽 확장

            if(sum==target) count++; // 합이 정확히 같을 때 카운트
        }

        System.out.println(count);

    }
    
}
