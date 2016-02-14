package crackbook;

import java.util.LinkedList;

/**
 * Created by Suheng on 12/23/15.
 */
public class LevelVisitedNode {
    public static void main(String[] args) {
        TreeNode<Integer> treeNode = null;
        treeNode = initBst(treeNode, 5);
        treeNode = initBst(treeNode, 4);
        treeNode = initBst(treeNode, 7);
        treeNode = initBst(treeNode, 8);
        treeNode = initBst(treeNode, 3);
        treeNode = initBst(treeNode, 2);
        treeNode = initBst(treeNode, 1);

        levelVisited(treeNode);
    }

    //层遍历
    public static void levelVisited(TreeNode<Integer> treeNode) {
        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            System.out.print(temp.data + " ");
        }
    }

    //初始化二叉树
    public static TreeNode<Integer> initBst(TreeNode<Integer> treeNode, int element) {
        if (treeNode == null) {
            return new TreeNode<Integer>(element, null, null);
        }

        if (treeNode.data > element) {
            treeNode = initBst(treeNode.left, element);
        } else if (treeNode.data < element) {
            treeNode = initBst(treeNode.right, element);
        } else {
            //do nothing
        }

        return treeNode;
    }
}
