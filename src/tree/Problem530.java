package tree;

import javax.swing.*;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class Problem530 {
    int min;
    int previous;

    // 二叉搜索树中序遍历得到的值序列是递增有序的，对升序数组求任意两个元素之差的绝对值的最小值，答案一定为相邻两个元素之差的最小值
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        previous = -1;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (previous != -1) {
            min = Math.min(min, node.val - previous);
        }
        previous = node.val;
        dfs(node.right);
    }
}
