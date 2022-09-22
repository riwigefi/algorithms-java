package binaryTree;

/**
 * 求二叉树中最大的路径和
 */
public class OneSideMax {
    int res = Integer.MIN_VALUE;
    int oneSideMax(BinaryTreeNode root) {

        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
        // 后序位置
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
