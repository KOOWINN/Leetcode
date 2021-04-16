package tree;

/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 */
public class Problem110 {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight, rightHeight;
        // 对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。
        // 如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1。
        // 如果左子树不平衡，则整个二叉树一定不平衡。如果左子树不平衡，则还要看右子树是否平衡。
        if ((leftHeight = height(root.left)) == -1
                || (rightHeight = height(root.right)) == -1
                || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
