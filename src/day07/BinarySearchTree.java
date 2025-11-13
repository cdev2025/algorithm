package day07;

class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    // 삽입 메서드 : 외부에서 호출하기 위한 메서드
    public void insert(int value){
        root = insertNode(root, value);
    }

    // 재귀적 삽입 메서드 : 실제로 노드를 삽입하는 로직 처리
    private TreeNode insertNode(TreeNode root, int value){
        // 빈 위치 찾으면 새 노드 생성해서 반환
        if( root == null ){
            root = new TreeNode(value);
            return root;
        }
        // 값이 현재 노드(root)보다 작으면 왼쪽 서브 트리에 삽입
        if(value < root.value){
            root.left = insertNode(root.left, value);
        }
        // 값이 현재 노드(root)보다 크면 오른쪽 서브 트리에 삽입
        else if(value > root.value){
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    // 중위 순회를 통한 트리 출력 메서드: 외부에서 호출하기 위한 메서드
    public void inorder(){
        inorderRec(root);
    }

    // 중위 순회를 통한 트리 출력을 재귀적으로 처리하는 메서드
    private void inorderRec(TreeNode root){
        if(root!=null){
            inorderRec(root.left);   // left 서브 트리
            System.out.print(root.value + " "); // 현재 노드
            inorderRec(root.right);  // right 서브 트리
        }
    }

    // 탐색 메서드 : 외부에서 호출하기 위한 메서드
    public boolean search(int value){
        return searchNode(root, value);
    }

    // 재귀적 탐색 메서드 : 노드가 존재하는지 재귀적으로 확인
    private boolean searchNode(TreeNode root, int value){
        // 빈 트리이거나 노드를 찾지 못한 경우
        if(root==null){
            return false;
        }
        // 찾는 값이 현재 노드 값과 일치하면 true반환
        if(value == root.value){
            return true;
        }
        // 찾는 값이 현재 노드 값보다 작으면 왼쪽 서브트리 탐색, 크면 오른쪽 서브트리 탐색
        return value < root.value ? searchNode(root.left, value) : searchNode(root.right, value);

    }

    // 삭제 메서드 : 외부에서 호출하기 위한 메서드
    public void delete(int value){
        root = deleteNode(root, value);
    }

    // 재귀적 삭제 메서드 : 노드를 찾아서 삭제하고 트리를 재구성
    private TreeNode deleteNode(TreeNode root, int value){
        // 빈 트리거나 노드를 찾지 못한 경우
        if(root == null) return root;

        // 삭제할 노드를 찾아서 재귀적 탐색
        if(value < root.value ){
            root.left = deleteNode(root.left, value);
        }else if(value > root.value){
            root.right = deleteNode(root.right, value);
        } else{ // 삭제할 노트를 찾은 경우
            // 노드가 하나 이하의 자식을 가진 경우
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;

            // 노드가 두 개의 자식을 가지는 경우
            // 오른쪽 서브트리에서 최소값 노드 찾음 (또는 왼쪽 서브트리에서 최대값 노드를 찾음 - 선택 ) => 현재 노드 값으로 대체
            root.value = minValue(root.right);

            // 오른쪽 서브트리에서 최소값 노드 삭제 (또는 왼쪽 서브트리에서 최대값 노드 삭제)
            root.right = deleteNode(root.right, root.value);
        }

        return root;
    }

    // 주어진 서브트리에서 최소값을 가진 노드의 값을 찾는 메서드
    private int minValue(TreeNode root){
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root=root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 트리에 여러 값을 삽입
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // 트리 출력: bst에서 중위 순회 사용하면 => 오름차순 출력 가능
        System.out.println("중위 순회로 트리 출력 : ");
        bst.inorder();
        System.out.println();

        // 탐색 : 특정값 (40) 을 가진 노드가 트리에 존재하는 확인
        System.out.println("트리에 40 이라는 값을 찾기 : ");
        System.out.println(bst.search(40) ? "찾았음" : "없음");

        // 특정 값을 가진 노드 삭제: 50
        System.out.println("트리에서 50 삭제: ");
        bst.delete(50);
        bst.inorder();
        System.out.println();
    }
    
}
