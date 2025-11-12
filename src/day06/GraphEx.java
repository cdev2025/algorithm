package day06;

import java.util.ArrayList;

public class GraphEx {
    public static void main(String[] args) {
        int[][] edge = {{1,2}, {1,3}, {2,4}, {3,4}, {3,5}, {4,5}};

        int nodeNum = 5;

        // 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        // 각 정점에 대해 빈 리스트 추가해서 인접리스트 초기화
        for(int i=0; i<=nodeNum; i++){
            adjList.add(new ArrayList<>());
        }

        // 인접 리스트에 간선 정보 추가
        for(int i=0; i<edge.length; i++){
            // 양방향 그래프. 두 정점 간의 각각 연결을 추가
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }

        // 인접 리스트 출력
        for(int i=1; i<adjList.size(); i++){// 각 정점에 대해 반복
            System.out.print(i + "의 인접 정점 : ");
            for( int j=0; j<adjList.get(i).size(); j++) {// 해당 정점의 인접 정점들을 출력
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println(); // 각 정점 출력 후 줄바꿈
        }
    }
}
