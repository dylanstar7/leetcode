package leetcode.answer.impl.middle;

import leetcode.answer.model.TreeNode;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author lijiakun
 * @date 2020/05/22 10:48
 */
public class buildTree {

    private HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int length = preorder.length;
        for(int i = 0; i< length; i++){
            map.put(inorder[i],i);
        }

        return build(preorder,inorder,0,length-1,0,length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft > preRight){
            return null;
        }

        int preRoot = preLeft;
        int inRoot = map.get(preorder[preRoot]);

        TreeNode root = new TreeNode();
        root.setVal(preorder[preRoot]);

        int leftSize = inRoot - inLeft;

        // 递归构造左子树
        root.setLeft(build(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inRoot - 1));
        root.setRight(build(preorder, inorder, preLeft + leftSize+1, preRight, inRoot+1, inRight)) ;
        return  root;

    }
}
