package crackbook;

import java.util.LinkedList;

/**
 * Created by Suheng on 12/23/15.
 */
public class MirrorTree {
    public static void main(String[] args) {
        TreeNode<Integer> treeNode = null;
        treeNode = initBst(treeNode, 4);
        treeNode = initBst(treeNode, 2);
        treeNode = initBst(treeNode, 3);
        treeNode = initBst(treeNode, 5);
        treeNode = initBst(treeNode, 7);
        treeNode = initBst(treeNode, 6);
        levelVisited(treeNode);
        System.out.println();
        mirrorTree(treeNode);
        levelVisited(treeNode);
    }


    //转换为镜像树
    public static TreeNode<Integer> mirrorTree(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode<Integer> temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;

        mirrorTree(treeNode.left);
        mirrorTree(treeNode.right);

        return treeNode;
    }

    //创建Bst
    public static TreeNode<Integer> initBst(TreeNode<Integer> treeNode, int element) {
        if (treeNode == null) {
            return new TreeNode<Integer>(element, null, null);
        }

        if (treeNode.data > element) {
            treeNode.left = initBst(treeNode.left, element);
        } else if (treeNode.data < element) {
            treeNode.right = initBst(treeNode.right, element);
        } else {
            //do nothing
        }

        return treeNode;
    }

    //层遍历非
    public static void levelVisited(TreeNode<Integer> treeNode) {
        java.util.Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

            System.out.print(temp.data + " ");
        }
    }
}
