package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 *
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Problem112 {
    // 递归解法
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    // 广度优先搜索解法
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int sum = valQueue.poll();
            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                valQueue.add(node.left.val + sum);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                valQueue.add(node.right.val + sum);
            }
        }
        return false;
    }
}
