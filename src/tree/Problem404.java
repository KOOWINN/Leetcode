package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Problem404 {
    // 深度优先搜索
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            sum += isLeafNode(root.left) ? root.left.val : sumOfLeftLeaves(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    // 广度优先搜索
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int sum = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    sum += node.left.val;
                } else {
                    nodeQueue.offer(node.left);
                }
            }
            if (node.right != null && !isLeafNode(node.right)) {
                nodeQueue.offer(node.right);
            }
        }
        return sum;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left==null && node.right == null;
    }
}
