package day04.baekjoon10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // try-with-resources문 : BufferedReader 자동으로 닫음
        try( BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ){

            // 수의 개수 N
            int N = Integer.parseInt(br.readLine());

            int[] numbers = new int[N];
            
            // N개의 수 입력
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(br.readLine());
            }

            // 정렬
            Arrays.sort(numbers);

            //출력 
            StringBuilder sb = new StringBuilder();
            for(int number: numbers){
                sb.append(number).append('\n');
            }
            System.out.print(sb.toString());

        } catch (IOException e){
            System.out.println("입출력 오류가 발생했습니다: " + e.getMessage());
        }

    }
    
}
