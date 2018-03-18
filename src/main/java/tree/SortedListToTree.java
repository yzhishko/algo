package tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SortedListToTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(nums[(nums.length - 1) / 2]);
        Queue<Part> queue = new LinkedList<>();
        queue.add(new Part(head, 0, nums.length - 1));

        while (!queue.isEmpty()) {
            Part curr = queue.poll();

            if (curr.mid - 1 >= curr.low) {
                TreeNode left = new TreeNode(nums[(curr.mid - 1 + curr.low) / 2]);
                curr.node.left = left;
                queue.add(new Part(left, curr.low, curr.mid - 1));
            }

            if (curr.mid + 1 <= curr.high) {
                TreeNode right = new TreeNode(nums[(curr.mid + 1 + curr.high) / 2]);
                curr.node.right = right;
                queue.add(new Part(right, curr.mid + 1, curr.high));
            }
        }

        return head;
    }
}

class Part {
    final int low;
    final int high;
    final TreeNode node;
    final int mid;

    Part(TreeNode node, int low, int high) {
        this.node = node;
        this.low = low;
        this.high = high;
        this.mid = low + (high - low) / 2;
    }
}