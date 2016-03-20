package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Suheng on 3/4/16.
 */
public class Problem111 {
    public static void main(String[] args) {
        TreeNode treeNode = null;
        treeNode = initBst(treeNode, 6);
        treeNode = initBst(treeNode, 5);
        treeNode = initBst(treeNode, 10);
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
        System.out.println(sumNumbers(treeNode));
        System.out.println("\nmaxPathSum" + maxPathSum(treeNode));
        levelVisited(treeNode);
        System.out.println(path(treeNode, 16, 0));
    }

    public static boolean path(TreeNode treeNode, int target, int sum) {
        if (treeNode == null) {
            if (sum == target) {
                return true;
            }else{
                return false;
            }
        }else {
            sum += treeNode.val;
            if (path(treeNode.left, target, sum)) {
                return true;
            } else {
                return path(treeNode.right, target, sum);
            }
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }

        return root;
    }

    public static int total = 0;

    private static int maxPathSum(TreeNode treeNode) {
        help(treeNode);
        return total;
    }

    public static void help(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumR(root, 0);
    }

    public static int sumR(TreeNode root, int x) {
        if (root.right == null && root.left == null) {
            return 10 * x + root.val;
        }
        int val = 0;
        if (root.left != null) {
            val += sumR(root.left, 10 * x + root.val);
        }
        if (root.right != null) {
            val += sumR(root.right, 10 * x + root.val);

        }

        return val;
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
