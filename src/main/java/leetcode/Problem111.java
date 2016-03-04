package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Suheng on 3/4/16.
 */
public class Problem111 {
    public static void main(String[] args) {
        TreeNode treeNode = null;
        treeNode = initBst(treeNode, 6);
        treeNode = initBst(treeNode, 5);
        treeNode = initBst(treeNode, 7);
        treeNode = initBst(treeNode, 3);
        treeNode = initBst(treeNode, 4);
        treeNode = initBst(treeNode, 2);
        System.out.println("pre-order (recursion)");
        preOrder(treeNode);
        System.out.println("\nin-order (recursion)");
        inOrder(treeNode);
        System.out.println("\npost-order (recursion)");
        postOrder(treeNode);
        System.out.println("\nlevel-visited (non-recursion)");
        levelVisited(treeNode);
        System.out.println("\nAll node of the treeNode (recursion)");
        System.out.print(getNodeNumsRec(treeNode));
        System.out.println("\nAll node of the treeNode (non-recursion)");
        System.out.print(getNodeNums(treeNode));

        System.out.println("\nThe deep");
        System.out.println(getDepthRec(treeNode));
    }

    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepthRec(root.left);
        int rightDepth = getDepthRec(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 获取结点个数非递归
     */
    public static int getNodeNums(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int number = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove();

            if (tmp.left != null) {
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            number++;
        }
        return number;
    }

    /**
     * 获取结点的个数递归
     */
    public static int getNodeNumsRec(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return getNodeNumsRec(treeNode.left) + getNodeNumsRec(treeNode.right) + 1;
        }
    }

    /**
     * 层遍历
     */
    public static void levelVisited(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove();
            if (tmp.left != null) {
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            System.out.print(tmp.val + " ");
        }
    }

    /**
     * preOrder tree
     */
    public static void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    /**
     * post-order
     */
    public static void postOrder(TreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.print(treeNode.val + " ");
        }
    }

    /**
     * inOrder
     */
    public static void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
            System.out.print(treeNode.val + " ");
            inOrder(treeNode.right);
        }
    }

    /**
     * 根据输入创建查找树
     */

    public static TreeNode initBst(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = initBst(root.right, val);
        } else if (val < root.val) {
            root.left = initBst(root.left, val);
        } else {
            //do nothing
        }

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
