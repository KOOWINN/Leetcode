package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *
 *
 * 示例 2:
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 */
public class Problem513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.offer(current);
        while (!queue.isEmpty()) {
            current = queue.poll();
            // 从左到右层次遍历时最后一个元素就是这棵树的右下角元素
            // 所以，从右到左层次遍历，那么最后一个元素就是这棵树的左下角元素
            if (current.right!=null) queue.offer(current.right);
            if (current.left!=null) queue.offer(current.left);
        }
        return current.val;
    }
}
