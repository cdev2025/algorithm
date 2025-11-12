package day06.graph;

import java.util.LinkedList;
import java.util.List;

// Node 정보 저장
public class Node {
    String name;
    List<Node> links;
    boolean visited;

    public Node(String name){
        this.name = name;
        this.links = new LinkedList<>();
    }

    @Override
    public String toString() {
        return name;
    }

    // 링크 추가 메서드
    public void link(Node node){
        links.add(node);
    }

    public void visit(){ // 방문 체크
        this.visited = true;
    }

    public void resetVisit(){
        this.visited = false;
    }

    public boolean isVisited() { // 방문 여부 확인
        return this.visited;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return name.equals(node.name); // name만 같으면 같다고 설정
    }
}
