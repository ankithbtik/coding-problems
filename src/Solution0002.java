import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class Solution0002 {
    public Node connect(Node root) {

        if(root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node curNode = q.poll();
            if(curNode != null){
                q.add(curNode.left);
                q.add(curNode.right);

                curNode.next = q.peek();
            }

            if(q.peek() == null) {
                q.add(null);
                q.poll();
            }
        }
        return root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}