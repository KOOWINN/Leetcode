package tree;

/**
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 * 注：该题与 Problem897 类似
 */
public class Interview1712 {
    TreeNode prev;
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        prev = dummyNode;
        dfs(root);
        return dummyNode.right;
    }

    // 二叉搜索树的中序遍历是有序的，所以我们可以利用一个前驱节点prev，记录上一个被处理的节点，
    // 当前节点被遍历到的时候，将prev.right指向当前节点node，然后node.left置空，prev指针后移到node，最后node进入右子树即可
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        root.left = null;
        prev.right = root;
        prev = root;

        dfs(root.right);
    }
}
