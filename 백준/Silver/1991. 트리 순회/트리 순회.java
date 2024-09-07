import java.io.*;
import java.util.*;

class Main {
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static Node[] tree;

    static void preOrder(Node node){ // 전위 순회
        if (node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) { // 중위 순회
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    static void postOrder(Node node) { // 후위 순회
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        tree = new Node[N+1]; // 노드 배열
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char rootValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[rootValue-'A'] == null) {
                tree[rootValue-'A'] = new Node(rootValue);
            }

            if (leftValue != '.') {
                tree[leftValue-'A'] = new Node(leftValue);
                tree[rootValue-'A'].left = tree[leftValue-'A'];
            }

            if (rightValue != '.') {
                tree[rightValue-'A'] = new Node(rightValue);
                tree[rootValue-'A'].right = tree[rightValue-'A'];
            }
        }

        // 전위
        preOrder(tree[0]);
        System.out.println();
        //중위
        inOrder(tree[0]);
        System.out.println();
        //후위
        postOrder(tree[0]);
        System.out.println();

        br.close();

    }
}
