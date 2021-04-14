package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkRecursively(root.left, root.right);
//        return checkRecursively(root.left, root.right);
    }

    //递归解法
    private boolean checkRecursively(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return checkRecursively(root1.left, root2.right) && checkRecursively(root1.right, root2.left);
    }

    //迭代解法
    private boolean checkIteratively(TreeNode u, TreeNode v){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || u.val != v.val) {
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
