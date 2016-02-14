package crackbook;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Suheng on 12/17/15.
 */
public class S7 {
    public static void main(String[] args) {

        TreeNode<Integer> r1 = new TreeNode<Integer>(1, null, null);
        TreeNode<Integer> r2 = new TreeNode<Integer>(2, null, null);
        TreeNode<Integer> r3 = new TreeNode<Integer>(3, null, null);
        TreeNode<Integer> r4 = new TreeNode<Integer>(4, null, null);
        TreeNode<Integer> r5 = new TreeNode<Integer>(5, null, null);
        TreeNode<Integer> r6 = new TreeNode<Integer>(6, null, null);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;

        TreeNode<Integer> treeNode = r1;

        /**
         * 熟练掌握的递归和非递归算法
         */

        System.out.println(getNodeNumLeafRec(treeNode));
    }


    //求叶子结点
    public static int getNodeNumLeafRec(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        }

        return getNodeNumLeafRec(treeNode.left) + getNodeNumLeafRec(treeNode.right);
    }


    //求第k层的结点个数
    public static int getNodeNumKthLevel(TreeNode treeNode, int k) {
        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;
        int currentLevel = 0;
        int nextLevel = 0;
        queue.add(treeNode);
        level++;
        currentLevel++;

        while (!queue.isEmpty() && level < k) {
            TreeNode tn = queue.poll();
            currentLevel--;
            if (tn.left != null) {
                queue.add(tn.left);
                nextLevel++;
            }
            if (tn.right != null) {
                queue.add(tn.right);
                nextLevel++;
            }


            if (currentLevel == 0) {
                level++;
                currentLevel = nextLevel;
                nextLevel = 0;
            }

        }

        return currentLevel;
    }

    //层遍历树
    public static void levelVisited(TreeNode treeNode) {
        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }

            System.out.print(t.data + " ");
        }
    }

    //后序遍历非递归
    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        java.util.Stack<TreeNode> stack1 = new Stack<TreeNode>();
        java.util.Stack<TreeNode> stack2 = new Stack<TreeNode>();

        stack1.push(treeNode);
        while (!stack1.isEmpty()) {
            TreeNode t = stack1.pop();
            stack2.push(t);
            if (t.left != null) {
                stack1.push(t.left);
            }
            if (t.right != null) {
                stack1.push(t.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }

    }

    //中序遍历非递归
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        java.util.Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode tn = treeNode;

        while (true) {
            while (tn != null) {
                stack.push(tn);
                tn = tn.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            tn = stack.pop();
            System.out.print(tn.data + " ");
            tn = tn.right;
        }
    }

    //前序遍历非递归
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        java.util.Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode t = treeNode;
        stack.push(t);

        while (t != null || !stack.isEmpty()) {
            if (t == null) {
                t = stack.pop();
            }
            System.out.print(t.data + " ");
            if (t.right != null) {
                stack.push(t.right);
            }
            t = t.left;
        }
    }


    //前序遍历(递归)
    //中左右
    public static void preOrderRec(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.data + " ");
            preOrderRec(treeNode.left);
            preOrderRec(treeNode.right);
        }
    }

    //中序遍历(递归)
    //左中右
    public static void inOrderRec(TreeNode treeNode) {
        if (treeNode != null) {
            inOrderRec(treeNode.left);
            System.out.print(treeNode.data + " ");
            inOrderRec(treeNode.right);
        }
    }

    //后序遍历(递归)
    public static void postOrderRec(TreeNode treeNode) {
        if (treeNode != null) {
            postOrderRec(treeNode.left);
            postOrderRec(treeNode.right);
            System.out.print(treeNode.data + " ");
        }
    }

    //获取树的深度(递归)
    public static int getDepthRec(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        return Math.max(getDepthRec(treeNode.left), getDepthRec(treeNode.right)) + 1;
    }

    //获取树的深度(非递归)
    public static int getDepth(TreeNode treeNode) {
        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();

        int count = 0;
        int currentLevel = 0;
        int nextLevel = 0;

        queue.add(treeNode);
        currentLevel++;

        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            currentLevel--;
            if (temp.left != null) {
                queue.add(temp.left);
                nextLevel++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextLevel++;
            }

            if (currentLevel == 0) {
                count++;
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }


        return count;
    }

    //求二叉树中的结点个数
    public static int getNodeNumRec(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return getNodeNumRec(treeNode.left) + getNodeNumRec(treeNode.right) + 1;
        }
    }

    //求二叉树中的结点个数非递归
    public static int getNodeNum(TreeNode<Integer> treeNode) {
        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int count = 0;
        queue.add(treeNode);
        count++;
        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
                count++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                count++;
            }
        }


        return count;
    }
}
