package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树题型主要是用培养递归思维的，而层序遍历属于迭代遍历，比较简单
// 看看层序遍历的基础框架吧
public class LevelBinaryTree {
    public Queue<BinaryTreeNode> traverseLevel(BinaryTreeNode root) {
        // 层序遍历要用到的队列
        Queue<BinaryTreeNode> q = new LinkedList<>();
        if (root == null) return q;
        // 将根节点放入队列的末尾
        q.offer(root);
        // 从上到下，层序遍历二叉树的每一层
        while (!q.isEmpty()) {
            // 队列不为空，就循环执行
            int sz = q.size();
            // 从左到右遍历当前这层的每一个节点
            for (int i = 0; i < sz; i++) {
                // 访问并取出队列中第一个元素
                BinaryTreeNode currNode = q.poll();
                // 将下一层的节点放入队列
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
        }
        return q;
    }


    // 也可以通过递归的方式，来实现二叉树的层序遍历
    // res 用来存储层序遍历的结果
    public List<List<Integer>> res = new ArrayList<>();

    // 递归实现层序遍历的主函数
    List<List<Integer>> levelTraverseByRecursive(BinaryTreeNode root) {
        if (root == null) return res;
        // root节点，视为第0层
        traverse(root, 0);
        return res;
    }

    void traverse(BinaryTreeNode root, int depth) {
        if (root == null) return;
        // 前序位置，看看是否已经存储 depth 层的节点了
        if (res.size() <= depth) {
            // 第一次进入depth层
            res.add(new LinkedList<>());
        }
        // 前序位置，在 depth 层添加 root 节点
        res.get(depth).add(root.val);
        // 左子树递归
        traverse(root.left, depth + 1);
        // 右子树递归
        traverse(root.right, depth + 1);
    }
}
