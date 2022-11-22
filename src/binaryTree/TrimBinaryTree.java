package binaryTree;

/**
 * 题目描述：给定一颗二叉搜索树，同时给定边界最小最大值[L,H],其中H>=L
 * 通过修剪二叉树，得到一颗新的二叉树，新二叉树的所有节点都在[L,H]区间
 * <p>
 * 二叉树的解法一般分为两种
 * 1。 使用外部变量，遍历整颗二叉树，得出答案
 * 2。 使用分解问题，分步计算，由每步的小答案，递归推出整体答案
 * <p>
 * 二叉树修剪，这里可以使用分解问题、分步计算的方式
 * 先明确问题怎么分解，怎么分步计算，怎么定义递归
 * 如果一个节点没有落在[L,H]区间内，则有两种情况
 * 1。 root.left<L,这种情况下，root节点本身和root的左子树的节点，都是小于L的，都需要被裁剪掉
 * 2。 root.right>H，这种情况下，root节点本身和root的右子树的节点，都是大于H的，都需要被裁剪掉
 * 明确了裁剪条件，可以递归函数来定义了
 */

public class TrimBinaryTree {
    BinaryTreeNode trimBinaryTreeWithLAndH(
            BinaryTreeNode root,
            int L,
            int H
    ) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode leftTrim = trimBinaryTreeWithLAndH(root.left, L, H);
        BinaryTreeNode rightTrim = trimBinaryTreeWithLAndH(root.right, L, H);
        if (root.val < L) {
            // 需要裁剪root节点本身以及root节点的左子树
            // 选右子树的根节点作为新的根节点
            return rightTrim;
        }
        if (root.val > H) {
            // 需要裁剪root节点本身以及root节点右子数
            // 选左子树的根节点作为新的根节点
            return leftTrim;
        }
        root.left = leftTrim;
        root.right = rightTrim;
        return root;
    }

    /**
     * 前序位置的代码执行，是自顶向下的，因为前序位置，是刚进入某个节点的时候
     * 后序位置的代码执行，则是自底向上，因为后序位置，是刚离开某个节点的时候
     * 这意味着：
     * 1。前序位置的代码，只能从递归函数的参数里，拿到父节点传过来的数据
     * 2。后序位置的代码，还能获取当前节点的两个子树被处理后的结果（左子树的递归函数，右子树的递归函数）
     * <p>
     * 有两个简单问题：
     * 1。如果把根节点看作第一层，如何打印出每一个节点所在的层次
     * 2。如何打印出每个节点的左右子树各有多少个节点
     */

    void logLevel(BinaryTreeNode root, int level) {
        if (root == null) return;
        System.out.printf("当前 %s, 在第%d层", root, level);
        logLevel(root.left, level + 1);
        logLevel(root.right, level + 1);
    }

    int computedSubTreeNodeCount(BinaryTreeNode root) {
        if (root == null) return 0;
        int leftNodeCount = computedSubTreeNodeCount(root.left);
        int rightNodeCount = computedSubTreeNodeCount(root.right);
        System.out.printf("当前节点 %s, 左子树有%d个节点", root, leftNodeCount);
        System.out.printf("当前节点 %s, 右子树有%d个节点", root, rightNodeCount);
        return leftNodeCount + rightNodeCount + 1;
    }
}
