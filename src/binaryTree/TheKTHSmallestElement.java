package binaryTree;

// 给一棵二叉树，找到二叉树中第K小的元素，如果没有，就返回0

public class TheKTHSmallestElement {
    int res = 0;
    int rank = 0;
    public void traverse(BinaryTreeNode root, int k) {
        // 遍历左子树
        traverse(root.left, k);
        // 中序遍历位置，判断逻辑
        rank++;
        if(k == rank) {
            // 找到目标元素，停止递归，直接返回结束函数
            res = root.val;
            return;
        }
        // 遍历右子树
        traverse(root.right, k);
    }
}
