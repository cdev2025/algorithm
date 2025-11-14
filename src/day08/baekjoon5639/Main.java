package day08.baekjoon5639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    // 전위 순회(preorder) 결과를 저장할 리스트
    static ArrayList<Integer> preorder = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        // 입력이 몇 줄일지 모르기 때문에 EOF까지 계속 읽음.
        while( ( line=br.readLine())!=null && !line.isEmpty() ){
            preorder.add(Integer.parseInt(line));
        }

        // 후위 순위(postorder) 출력
        postOrder(0, preorder.size()-1);
    }

    // 후위 순위 생성 함수
    // BST의 특징을 활용해서 전위 순위 값을 -> 후위 순위로 만듦
    // 전위 순위 특징 : [루트, 왼쪽 서브트리..., 오른쪽 서브트리...]
    //  -> 루트보다 작은 값이 왼쪽 서브트리
    //  -> 루트보다 큰 값이 오른쪽 서브크리
    // 이 범위를 찾아서 재귀적으로 우휘 순회를 만들 예정
    // left, right => 현재 서브트리 값의의 범위(preorder[left] ~ preorder[right])
    static void postOrder(int left, int right){
        if(left > right) return;

        int root = preorder.get(left); // 전위 순위 제일 첫번째 오는 값이 root

        // 오른쪽 서브트리가 시작되는 위치를 찾기 : root보다 큰값 
        int idx = left +1;
        while(idx<=right && preorder.get(idx) < root){
            idx++;
        }
        // idx는 오른쪽 서브트리 시작점

        // 1. 왼쪽 서브트리 후위 순회
        postOrder(left+1, idx-1);

        // 2. 오른쪽 서브트리 후위 순회
        postOrder(idx, right);

        // 3. 루트 출력
        System.out.println(root);
    }
    
}
