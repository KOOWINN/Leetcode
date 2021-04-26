package tree;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *
 *
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 */
public class Problem783 {
    int prev;
    int ans;
    public int minDiffInBST(TreeNode root) {
        prev = -1;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != -1) {
            ans = Math.min(ans, root.val - prev);
        }
        prev = root.val;
        dfs(root.right);
    }
}
