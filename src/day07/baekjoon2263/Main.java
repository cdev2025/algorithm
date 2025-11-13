package day07.baekjoon2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] inorder, postorder, idxInorder;
    static StringBuilder preorderResult = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        idxInorder = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            inorder[i] = Integer.parseInt(st.nextToken());
            idxInorder[inorder[i]] = i; // 인오더 값의 인덱스 저장
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        findPreorder(0, n-1, 0, n-1);
        System.out.println(preorderResult.toString());
    }

    // 프리오더를 찾는 함수 : 재귀 활용
    static void findPreorder(int inStart, int inEnd, int postStart, int postEnd){
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd]; // 포스트 오더의 마지막 값이 현재 root
        preorderResult.append(root + " "); // 프리오더 결과에 root 추가 : 전위 탐색은 현재 노드(root) 먼저 탐색

        int rootIdx = idxInorder[root]; // 인오더에서 현재 루트의 인덱스
        int leftSize = rootIdx - inStart; // 왼쪽 서브트리의 크기

        // 왼쪽 서브트리 탐색
        findPreorder(inStart, rootIdx-1 , postStart, postStart+leftSize-1);
        // 오른쪽 서브트리 탐색
        findPreorder(rootIdx+1, inEnd , postStart+leftSize, postEnd-1);
    }
}
