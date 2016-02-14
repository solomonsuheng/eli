package crackbook;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Suheng on 12/16/15.
 */
public class S6 {
    //    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//        TreeNode<Integer> treeRoot = initTree(nums);
//
//
//        System.out.print("先序遍历: ");
//        preOrder(treeRoot);
//        System.out.print("\n中序遍历: ");
//        midOrder(treeRoot);
//        System.out.print("\n后序遍历: ");
//        postOrder(treeRoot);
//        System.out.print("\n层遍历: ");
//        levelVisited(treeRoot);
//
//        System.out.print("\n先序遍历非递归: ");
//        preOrderNonRec(treeRoot);
//        System.out.print("\n中序遍历非递归: ");
//        midOrderNonRec(treeRoot);
//        System.out.print("\n求二叉树中节点的个数: " + countOfTheTree(treeRoot));
//
//        System.out.print("\n求二叉树中节点的个数(递归算法): " + countOfTreeRec(treeRoot));
//
//        System.out.print("\n求二叉树的深度为(递归算法): " + getDeepRec(treeRoot));
//        System.out.print("\n求二叉树的深度: " + getDeep(treeRoot));
//        System.out.println();
//    }
    public static void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<Integer>(1, null, null);
        TreeNode<Integer> tt = null;
        tt = initBst(tt, 5);
        tt = initBst(tt, 1);
        tt = initBst(tt, 6);
        tt = initBst(tt, 7);
        tt = initBst(tt, 2);
        tt = initBst(tt, 3);

        findThePath(tt, 11, new String());

    }

    public static void test(String list) {
        if (list.length() > 10) {
            return;
        } else {
            list += 1;
            System.out.println(list);
        }
    }

    public static void findThePath(TreeNode<Integer> treeNode, int sum, String path) {
        if (treeNode == null) {
            return;
        } else {
            path += treeNode.data;
            sum -= treeNode.data;
            if (sum == 0) {
                System.out.println(path);
            }

            findThePath(treeNode.left, sum, path);
            findThePath(treeNode.right, sum, path);
        }
    }


    //根据元素删除结点
    public static TreeNode<Integer> remove(int element, TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return null;
        }

        if (element > treeNode.data) {
            //查找过程,到右子树进行查找
            treeNode.right = remove(element, treeNode.right);
        } else if (element < treeNode.data) {
            //查找过程,到左子树进行查找
            treeNode.left = remove(element, treeNode.left);
        } else if (treeNode.left != null && treeNode.right != null) {
            //查找到了,而且左右子树都不为空
            //首先将右子树的最小元素替换掉该结点,然后删除右子树最小的元素
            treeNode.data = findTheMinElement(treeNode.right);
            remove(treeNode.data, treeNode.right);
        } else {
            //查找到了,不都存在
            //如果其结点只包含了左子树,或者右子树的话,此时直接删除该结点,并将其左子树
            //或者右子树设置为其父结点的左子树或者右子树即可
            treeNode = (treeNode.left != null) ? treeNode.left : treeNode.right;
        }

        return treeNode;
    }

    //删除结点
    public static TreeNode<Integer> remove(TreeNode<Integer> treeNode, int element) {
        if (treeNode == null) {
            return null;
        }

        if (treeNode.data > element) {
            //寻找要删除的结点
            treeNode.left = remove(treeNode.left, element);
        } else if (treeNode.data < element) {
            //寻找要删除的结点
            treeNode.right = remove(treeNode.right, element);
        } else if (treeNode.left != null && treeNode.right != null) {
            //如果要删除结点的左右子树都存在
            treeNode.data = findTheMinElement(treeNode.right);
            treeNode.right = remove(treeNode.right, treeNode.data);
        } else {
            treeNode = (treeNode.left != null) ? treeNode.left : treeNode.right;
        }

        return treeNode;
    }

    //寻找最大的元素,最大的元素在二叉查找树的最右孩子
    public static int findTheMaxElement(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return -Integer.MAX_VALUE;
        }
        TreeNode<Integer> tt = treeNode;
        while (tt.right != null) {
            tt = tt.right;
        }


        return tt.data;
    }

    //找寻最小的元素,因为是二叉排序树,所以最左孩子就是最小元素
    public static int findTheMinElement(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return -Integer.MAX_VALUE;
        }
        TreeNode<Integer> tt = treeNode;
        while (tt.left != null) {
            tt = tt.left;
        }

        return tt.data;
    }


    //从二叉查找树中查找元素
    public static boolean findTheElementFromBST(TreeNode<Integer> treeNode, int element) {
        if (treeNode == null) {
            return false;
        }

        if (treeNode.data > element) {
            return findTheElementFromBST(treeNode.left, element);
        } else if (treeNode.data < element) {
            return findTheElementFromBST(treeNode.right, element);
        } else {
            return true;
        }

    }

    //创建二叉查找树
    public static TreeNode<Integer> initBst(TreeNode<Integer> treeNode, int element) {
        if (treeNode == null) {
            treeNode = new TreeNode<Integer>(element, null, null);
            return treeNode;
        }

        if (element > treeNode.data) {
            treeNode.right = initBst(treeNode.right, element);
        } else if (element < treeNode.data) {
            treeNode.left = initBst(treeNode.left, element);
        } else {
            //equals do nothing

        }

        return treeNode;
    }

    //获取深度非递归算法
    public static int getDeep(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        int deep = 0;
        int currentNode = 1;
        int nextNode = 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            currentNode--;
            if (t.left != null) {
                queue.add(t.left);
                nextNode++;
            }
            if (t.right != null) {
                queue.add(t.right);
                nextNode++;
            }

            if (currentNode == 0) {
                deep++;
                currentNode = nextNode;
                nextNode = 0;
            }
        }

        return deep;
    }

    //获取树的深度递归算法
    public static int getDeepRec(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return Math.max(getDeep(treeNode.left), getDeep(treeNode.right)) + 1;
        }

    }

    //获取二叉树的节点个数递归算法
    public static int countOfTreeRec(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return countOfTreeRec(treeNode.left) + countOfTreeRec(treeNode.right) + 1;
        }
    }

    //获取二叉树的节点的个数,可以使用层遍历,进行节点的统计
    public static int countOfTheTree(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        }
        int count = 0;
        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        count++;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
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


    //给定一棵树,交换左右孩子
    public static void changeLeftAndRight(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        } else {
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            changeLeftAndRight(treeNode.left);
            changeLeftAndRight(treeNode.right);
        }
    }

    //中序遍历非递归
    public static void midOrderNonRec(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(treeNode);
        TreeNode tempPointer = stack.pop();
        while (tempPointer != null || !stack.isEmpty()) {
            if (tempPointer != null) {
                stack.push(tempPointer);
                tempPointer = tempPointer.left;
            } else {
                tempPointer = stack.pop();
                System.out.print(tempPointer.data + " ");
                tempPointer = tempPointer.right;
            }
        }
    }

    //先序遍历非递归
    public static void preOrderNonRec(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        java.util.Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    //层遍历树
    public static void levelVisited(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        java.util.Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    //先序遍历法
    public static void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.data + " ");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    //中序遍历法
    public static void midOrder(TreeNode treeNode) {
        if (treeNode != null) {
            midOrder(treeNode.left);
            System.out.print(treeNode.data + " ");
            midOrder(treeNode.right);
        }
    }


    //后序遍历法
    public static void postOrder(TreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.print(treeNode.data + " ");
        }
    }


    //根据层来创建二叉树
    public static TreeNode<Integer> initTree(int... nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<Integer>(nums[0], null, null);

        TreeNode<Integer> tempRoot = root;
        java.util.Queue<TreeNode<Integer>> queue = new java.util.LinkedList<TreeNode<Integer>>();

        queue.add(root);
        TreeNode<Integer> pointer = queue.poll();

        for (int i = 1; i < nums.length; ) {
            TreeNode<Integer> tempNode = new TreeNode<Integer>(nums[i], null, null);
            if (pointer.left == null) {
                pointer.left = tempNode;
                queue.offer(pointer.left);
            } else if (pointer.right == null) {
                pointer.right = tempNode;
                queue.offer(pointer.right);
            } else {
                pointer = queue.poll();
                continue;
            }
            i++;
        }

        return root;
    }
}
