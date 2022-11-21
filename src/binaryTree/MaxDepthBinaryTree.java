package binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树题目的递归解法可以分为两类思路：
 * 第一类是遍历一遍二叉树得出答案，对应回溯算法核心框架
 * 第二类是通过分解问题计算出答案，对应动态规划核心框架
 * 比如二叉树的最大深度求解
 * 所谓最大深度就是根节点到最远叶子节点的路径上的节点数
 */

public class MaxDepthBinaryTree {
    // 第一种思路，使用外部变量记录每个节点所在的深度，取最大值就可以得到最大深度
    int res = 0;
    int depth = 0;

    // 配合外部遍历，遍历二叉树，记录每个节点的深度，不断更新最大深度值，直到遍历完整颗二叉树，得到当前二叉树的最大深度
    void traverseRecordDepth(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置,深度加1
        depth++;
        if (root.left == null && root.right == null) {
            // 当前节点是叶子节点
            // 比较现有的最大深度，和当前节点的深度，取较大值作为新的最大深度
            res = Math.max(depth, res);
        }
        // 遍历左子树
        traverseRecordDepth(root.left);
        // 遍历右子树
        traverseRecordDepth(root.right);
        // 后序位置，深度减1，因为就要退出当前节点了
        depth--;
        // 前序位置是进入一个节点的时候，后序位置是离开一个节点的时候，depth是记录当前递归到的节点的深度，
        // 所以后序位置离开一个节点的时候，就是回退到上一级节点，depth当然要减1了
        // 对于res的更新，前中后序位置没讲究，就是得在depth自增之后，depth自减之前
    }


    // 除了遍历每个节点，比较每个节点深度，得到解，还有一种方法就是，通过子树的最大深度，得出整颗二叉树的最大深度
    // 这样就是分解问题，分步计算答案的思路
    int computedMaxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左子树和右子树的最大深度
        int leftMax = computedMaxDepth(root.left);
        int rightMax = computedMaxDepth(root.right);

        // 定义一颗二叉树的最大深度：比较左子树和右子树的深度，取较大的，再加上根节点自己+1
        int max = Math.max(leftMax, rightMax) + 1;

        // 返回最大深度
        return max;
    }


    // 如何利用分解问题，分步计算问题的思路，来计算一个二叉树的前序遍历结果（也就是不要借助外部变量）
    List<Integer> computedPreorder(BinaryTreeNode root) {

        // 首先明确结果的定义
        // 一颗二叉树的前序遍历结果，等于这棵树的根节点+左子树的前序遍历结果+右子树的前序遍历结果
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        // 左子树的前序遍历结果
        List<Integer> leftPreorderRes = computedPreorder(root.left);
        // 右子树的前序遍历结果
        List<Integer> rightPreorder = computedPreorder(root.right);

        // 整颗树的前序遍历结果
        res.add(root.val);
        res.addAll(leftPreorderRes);
        res.addAll(rightPreorder);
        return res;
    }

}
