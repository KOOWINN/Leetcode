package tree;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：[2,2,2,5,2]
 * 输出：false
 */
public class Problem965 {
    public boolean isUnivalTree(TreeNode root) {
        boolean isLeftUnival = (root.left == null || (root.left.val == root.val && isUnivalTree(root.left)));
        boolean isRightUnival = (root.right == null || (root.right.val == root.val && isUnivalTree(root.right)));
        return isLeftUnival && isRightUnival;
    }
}
