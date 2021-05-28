package tree;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 *         1                 1
 *        / \                 \
 *       2   5        =>       2
 *      / \   \                 \
 *     3   4   6                 3
 *                                \
 *                                 4
 *                                  \
 *                                   5
 *                                    \
 *                                     6
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 */
public class Problem114 {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current!=null) {
            // 如果左子树不为空，则找到这颗左子树中前序遍历时最后被访问到的那个节点lastNode，
            // 然后将当前根节点的右子节点作为lastNode的右子节点，
            // 然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。
            if (current.left!=null){
                TreeNode leftRoot = current.left;
                TreeNode lastNode = leftRoot;
                while (lastNode.right != null){
                    lastNode = lastNode.right;
                }
                lastNode.right = current.right;
                current.left = null;
                current.right = leftRoot;
            }
            // 当前节点处理完成之后，继续处理它的右子节点，直到所有节点都处理结束
            current = current.right;
        }
    }
}
