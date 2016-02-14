package test;

/**
 * Created by Suheng on 12/21/15.
 */
public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;


    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
