package day06.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS / DFS
public class GraphMain {
    public static void main(String[] args) {
        // Graph의 Node, Edge 구성
 /*       List<Node> nodes = new LinkedList<>();

        nodes.add(new Node("A"));
        nodes.add(new Node("B"));
        nodes.add(new Node("C"));
        nodes.add(new Node("D"));
        nodes.add(new Node("E"));

        System.out.println(nodes);*/

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        b.link(e);
        c.link(b);
        c.link(d);
        d.link(c);
        d.link(a);
        d.link(e);
        e.link(b);
        e.link(d);

        Node target = e;

        // BFS : 예약 목록을 Queue를 사용
        Queue<Node> queue = new LinkedList<>();
        queue.offer(a); // a에서 시작

        while(!queue.isEmpty()){
            Node n = queue.poll(); // 대기열에서 node 가져 옴
            n.visit(); // 방문 표시
            System.out.println(n);

            if(n.equals(target)) {// 타겟 노드 찾았는지 체크
                System.out.println("찾았다!!!" + n);
                break;
            }

            for(Node l : n.links){
                if(l.isVisited()) continue;
                if(queue.contains(l)) continue;
                queue.offer(l); // 인접노드 대기열에 추가
            }
        }

        System.out.println("=================");
        a.resetVisit();
        b.resetVisit();
        c.resetVisit();
        d.resetVisit();
        e.resetVisit();

        // DFS : 예약 목록을 스택을 사용
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(a); // a에서 시작

        while(!stack.isEmpty()){
            Node n = stack.pop(); // 대기열에서 node 가져 옴
            n.visit(); // 방문 표시
            System.out.println(n);

            if(n.equals(target)) {// 타겟 노드 찾았는지 체크
                System.out.println("찾았다!!!" + n);
                break;
            }

            for(Node l : n.links){
                if(l.isVisited()) continue;    // 이미 방문했으면 pass
                if(stack.contains(l)) continue; // 대기열에 포함되어 있으면 pass
                stack.push(l); // 인접노드 대기열에 추가
            }
        }

    }
}
