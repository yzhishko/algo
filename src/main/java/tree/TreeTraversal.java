import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] arr) {
        TreeNode tree = new TreeNode(4);

        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);

        tree.right = new TreeNode(6);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(7);

        System.out.print("Preorder: ");
        tree.preOrder();

        System.out.println("");
        System.out.print("InOrder:  ");
        tree.inOrder();

        System.out.println("");
        System.out.print("Dfs:      ");
        tree.dfs();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    void preOrder() {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(this);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.poll();

            if (curr == null) {
                continue;
            }

            System.out.print(curr.val + " ");

            stack.addFirst(curr.right);
            stack.addFirst(curr.left);
        }
    }

    void inOrder() {
        Deque<TreeNode> stack = new LinkedList<>();

        leftSubtree(stack, this);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pollFirst();
            System.out.print(currNode.val + " ");

            leftSubtree(stack, currNode.right);
        }
    }

    void leftSubtree(Deque<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.addFirst(node);
            node = node.left;
        }
    }

    void dfs() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                continue;
            }

            System.out.print(curr.val + " ");

            queue.add(curr.left);
            queue.add(curr.right);
        }
    }
}









