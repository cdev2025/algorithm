package day07;

import java.util.LinkedList;
import java.util.Queue;

// 이진 트리 순회 예제
// 트리 노드 나타내는 클래스
class TreeNode {
    int value; // 노드에 저장된 값
    TreeNode left; // 왼쪽 자식 노드를 가리키는 포인터
    TreeNode right; // 오른쪽 자식 노드를 가리키는 포인터

    // 생성자에서 초기화
    TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeEx {
    TreeNode root; // 트리의 루트 노드

    // 전위 순회 (Preorder) : DFS - stack
    // 현재 노드 -> 왼쪽 서브 트리 -> 오른쪽 서브 트리 
    public void preorder(TreeNode node){
        if (node == null) return; // base case : 종료 조건

        System.out.print(node.value + " "); // 현재 노드
        preorder(node.left); // left subtree
        preorder(node.right);  // right subtree
    }

    // 중위 순회 (Inorder) : DFS - stack
    // 왼쪽 서브 트리 -> 현재 노드 -> 오른쪽 서브 트리
    public void inorder(TreeNode node){
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    // 후위 순회 (Postorder) : DFS - stack
    // 왼쪽 서브 트리 -> 오른쪽 서브 트리 -> 현재 노드
    public void postorder(TreeNode node){
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    // 레벨 순회 (Levelorder, BFS - queue)
    public void levelorder(TreeNode node){
        if (node == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // 큐에서 노드 꺼내기
            System.out.print(current.value + " ");

            // 왼쪽 자식이 있으면 큐에 추가
            if(current.left!=null){
                queue.add(current.left);
            }

            // 오른쪽 자식이 있으면 큐에 추가
            if(current.right!=null){
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeEx tree = new BinaryTreeEx();

        // 예제 트리 구성
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(7);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(8);
        tree.root.right = new TreeNode(15);
        tree.root.right.right = new TreeNode(20);

        // 전위 순회
        System.out.println("전위 순회: ");
        tree.preorder(tree.root);
        System.out.println();

        // 중위 순회
        System.out.println("중위 순회: ");
        tree.inorder(tree.root);
        System.out.println();

        // 후위 순회
        System.out.println("후위 순회: ");
        tree.postorder(tree.root);
        System.out.println();

        // 레벨 순회
        System.out.println("레벨 순회: ");
        tree.levelorder(tree.root);
        System.out.println();
    }
}
