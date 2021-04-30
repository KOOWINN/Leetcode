package tree;

/**
 * 面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 */
public class Interview0404 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }

    private int dfs(TreeNode root) {
        if (root==null) return 0;
        int left = dfs(root.left);
        if (left==-1) return -1;
        int right = dfs(root.right);
        if (right==-1) return -1;
        return Math.abs(left - right) < 2 ? (Math.max(left, right) + 1) : -1;
    }
}
