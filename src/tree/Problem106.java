package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Problem106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            throw new RuntimeException("Invalid input...");
        }
        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, len - 1, map, 0, len - 1);
    }

    private TreeNode buildTree(int[] postOrder, int postLeft, int postRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        int rootVal = postOrder[postRight];
        int pIndex = map.get(rootVal);
        TreeNode root = new TreeNode();
        root.val = rootVal;
        int sizeOfLeftChildTree = pIndex - inLeft;
        root.left = buildTree(postOrder, postLeft, postLeft + sizeOfLeftChildTree - 1, map, inLeft, pIndex - 1);
        root.right = buildTree(postOrder, postLeft + sizeOfLeftChildTree, postRight - 1, map, pIndex + 1, inRight);
        return root;
    }
}
