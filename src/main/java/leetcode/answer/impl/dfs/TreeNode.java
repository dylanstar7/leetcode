package leetcode.answer.impl.dfs;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2021/04/01 10:48
 */
public class TreeNode {

    private int val;

    public TreeNode left() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    private TreeNode left;

    public TreeNode right() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    private TreeNode right;

    private TreeNode(int x) {
        this.val = x;
    }
}
