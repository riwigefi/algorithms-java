package binaryTree;


// 根据前序遍历和中序遍历的结果，还原一棵二叉树
public class RecoverTree {

    public BinaryTreeNode build(
            int[] preorder,
            int preStart,
            int preEnd,
            int[] inorder,
            int inStart,
            int inEnd
    ) {
        // 前序位置，寻找左右子树的索引
        if (preStart > preEnd) {
            return null;
        }
        // 取出前序遍历结果中的第一个节点
        int rootVal = preorder[preStart];
        int index = 0;
        // 遍历中序遍历结果
        for(int i = inStart; i <= inEnd; i++) {
            // 如果中序遍历结果中第i个位置的节点值等于前序遍历的第一个结果
            if(inorder[i] == rootVal) {
                // 记录位置i，退出当前循环
                index = i;
                break;
            }
        }
        // 计算左子树的大小
        int leftSize = index - inStart;
        BinaryTreeNode root = new BinaryTreeNode(rootVal);

        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
