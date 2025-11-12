package day06;

// 인접 행렬 예제
public class GraphEx02 {
    private boolean[][] adjMatrix; // 그래프의 인접 행렬을 저장할 2차원 배열
    private int V; // 정점 개수

    public GraphEx02(int V){
        this.V = V;
        adjMatrix = new boolean[V+1][V+1]; // 정점의 개수에 맞는 크기의 2차원 배열 : false 초기화
    }

    // 간선 추가 메서드 : 무방향 그래프라  양방향 간선 추가
    void addEdge(int v, int w){
        adjMatrix[v][w] = true;
        adjMatrix[w][v] = true;
    }

    // 그래프 인접 행렬 출력하는 메서드
    void printGraph(){
        System.out.println("그래프의 인접 행렬: ");
        for( int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                System.out.print((adjMatrix[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        GraphEx02 g = new GraphEx02(5); // 5개의 정점을 가진 그래프 생성

        // 간선 추가
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,5);

        g.printGraph();
    }

}
