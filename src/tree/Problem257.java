package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Problem257 {

    // 递归方法
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, "", paths);
        return paths;
    }

    private void binaryTreePaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(sb.toString());
        } else {
            sb.append("->");
            binaryTreePaths(root, sb.toString(), paths);
            binaryTreePaths(root, sb.toString(), paths);
        }
    }

    // 广度优先遍历方法
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                paths.add(path);
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                pathQueue.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                pathQueue.add(path + "->" + node.right.val);
            }
        }
        return paths;
    }
}
