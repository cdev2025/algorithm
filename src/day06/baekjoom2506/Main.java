package day06.baekjoom2506;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Node{
    int id; // 컴퓨터 번호
    List<Node> adj; // 이 노드에 직접 연결된 컴퓨터 리스트
    boolean visited;

    public Node(int id){
        this.id = id;
        adj = new LinkedList<>();
    }

    public void link(Node node){
        adj.add(node);
    }
}

public class Main {
    static int count = 0; // 감연된 컴퓨터 수 count

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 컴퓨터 수
        int M = sc.nextInt(); // 연결 (간선) 수

        Node[] computers = new Node[N+1]; // 1번부터 사용하려고(컴퓨터 번호와 index 맞추려고, 0은 버림)
        for(int i=1; i<=N; i++){
            computers[i] = new Node(i);
        }

        // 연결 정보를 바탕으로 그래프 구성 : 양방향 연결
        for(int i=0; i<M; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            computers[u].link(computers[v]);
            computers[v].link(computers[u]);
        }

        // 1번 컴퓨터에서 시작해서 DFS 실행
        dfs(computers[1]);

        System.out.println(count-1); // 1번 컴퓨터 자신을 제외한 감염된 컴퓨터 수

        sc.close();
    }

    // DFS 메서드 : 재귀 => 함수호출 stack 사용
    public static void dfs(Node node){
        if (node.visited) return; // 이미 방문한 노드면 건너뜀

        node.visited = true; // 방문 처리
        count++; // 감연된 컴퓨터 수 증가

        // 현재 노트에 연결된 모든 노드에 대해 DFS를 재귀적으로 실행
        for( Node adjNode : node.adj){
            dfs(adjNode);
        }
    }
}
