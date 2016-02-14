package test;

/**
 * Created by Suheng on 12/21/15.
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode<Integer> treeNode = null;
        treeNode = initBst(treeNode, 4);
        treeNode = initBst(treeNode, 2);
        treeNode = initBst(treeNode, 3);
        treeNode = initBst(treeNode, 5);
        treeNode = initBst(treeNode, 1);
        treeNode = initBst(treeNode, 7);
        treeNode = initBst(treeNode, 6);
        treeNode = initBst(treeNode, 8);
    }


    //创建查找树
    public static TreeNode<Integer> initBst(TreeNode<Integer> treeNode, int element) {
        if (treeNode == null) {
            return new TreeNode<Integer>(element, null, null);
        }


        //寻找插入位置进行插入
        if (treeNode.data > element) {
            //插入位置在左子树
            treeNode.left = initBst(treeNode.left, element);
        } else if (treeNode.data < element) {
            //插入位置在右子树
            treeNode.right = initBst(treeNode.right, element);
        } else {
            //do nothing
        }

        return treeNode;
    }
}
