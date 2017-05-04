package main;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LC226InvertBinaryTree {


    public TreeNode invertTreeRecursive(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode treeNode = queue.poll();
            TreeNode tmpNode = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmpNode;
            if(!Objects.isNull(treeNode.left)){
                queue.offer(treeNode.left);
            }
            if(!Objects.isNull(treeNode.right)){
                queue.offer(treeNode.right);
            }
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
