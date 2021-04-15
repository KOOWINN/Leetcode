package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || (preorder.length!=inorder.length)) {
            throw new RuntimeException("Incorrect input...");
        }
        int preLen = preorder.length;
        int inLen = inorder.length;
        // 构造哈希映射，帮助我们快速定位中序遍历中的根节点
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen-1, map, 0, inLen-1);
    }

    /**
     *
     * @param preorder  前序遍历序列
     * @param preLeft   前序遍历序列子区间的左边界
     * @param preRight  前序遍历序列子区间的右边界
     * @param map       中序遍历中，数值与下标的映射关系
     * @param inLeft    中序遍历子区间的左边界
     * @param inRight   中序遍历子区间的右边界
     * @return 二叉树的根节点
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {  // 递归终止条件
            return null;
        }
        int rootVal = preorder[preLeft];
        int pIndex = map.get(rootVal);
        TreeNode root = new TreeNode();
        root.val = rootVal;
        int sizeOfLeftSubTree = pIndex - inLeft;
        root.left = buildTree(preorder, preLeft + 1, preLeft + sizeOfLeftSubTree, map, inLeft, pIndex - 1);
        root.right = buildTree(preorder, preLeft + sizeOfLeftSubTree + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }
}
