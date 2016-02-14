package crackbook;

/**
 * Created by Suheng on 12/16/15.
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
