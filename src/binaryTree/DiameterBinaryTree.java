package binaryTree;

/**
 * 解答二叉树题目时，一旦发现题目和子树有关，那么大概率要给递归函数设置合理的定义和返回值，而且要在后序位置写代码
 * 比如，计算一棵二叉树的最大直径
 * 所谓二叉树的直径长度，就是任意两个结点之间的路径长度，但是最长的直径并不一定要穿过根节点
 * 解决这道题的关键在于，每一棵二叉树的直径长度，就是一个节点的左右子树，最大深度之和
 * 那么只要遍历每个节点，计算出每个节点最大深度，取出所有节点中，和最大的那个
 */

public class DiameterBinaryTree {
    int maxDiameter = 0;

    int maxDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        // 后序位置，计算最大直径
        int myDiameter = leftMaxDepth + rightMaxDepth;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        // 返回当前节点的最大深度
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
}
