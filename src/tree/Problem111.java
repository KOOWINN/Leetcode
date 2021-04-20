package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class Problem111 {

    // 深度优先搜索
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    // 广度优先搜索
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.treeNode;
            int depth = queueNode.depth;
            if (treeNode.left == null && treeNode.right == null) {
                return depth;
            }
            if (treeNode.left != null) {
                queue.add(new QueueNode(treeNode.left, depth + 1));
            }
            if (treeNode.right != null) {
                queue.add(new QueueNode(treeNode.right, depth + 1));
            }
        }
        return 0;
    }

    static class QueueNode{
        TreeNode treeNode;
        int depth;

        public QueueNode(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}
