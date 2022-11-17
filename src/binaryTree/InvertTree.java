package binaryTree;

public class InvertTree {


    // 遍历二叉树，交换每个节点的子节点
    BinaryTreeNode traverseSolution(BinaryTreeNode root) {
        traverse(root);
        return root;
    }

    // 二叉树遍历函数
    public void traverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        //  前序位置，将节点的左右子节点交换
        BinaryTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 遍历框架，去遍历剩余的左右子节点
        traverse(root.left);
        traverse(root.right);
    }

    // 用【分解问题】的思维模式解决
    // 对于某一个二叉树节点x执行`invertTree(x)`
    // `invertTree(x.left)`把x的左子数翻转，`invertTree(x.right)`翻转右子树
    // 翻转完了后，把x的左右子树交换
    BinaryTreeNode invertTree2(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        // 利用函数定义，先翻转左右子树
        BinaryTreeNode left = invertTree2(root.left);
        BinaryTreeNode right = invertTree2(root.right);

        // 交换左右子树
        root.left = right;
        root.right = left;

        // 交换完了，以root为根的两颗二叉树已经翻转
        return root;
    }
}
